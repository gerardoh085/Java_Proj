
/***
 * Recursion.java 
 * @author: Gerardo Hernandez Macoto
 */

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Recursion {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a folder name:");
        String folder = keyboard.nextLine();

        System.out.println("Enter a filename:");
        String filename = keyboard.nextLine();
        String found = findFile(folder, filename);
        if (found.equals("")) {
            System.out.println("File " + filename + " not found in " + folder);
        } else {
            System.out.println("File " + filename + " found at " + found);
        }

        // Testing getSize
        System.out.println("Enter a folder name:");
        String folderName = keyboard.nextLine();
        long size = getSize(folderName);
        if (size == 0) {
            System.out.println("Folder not found");
        } else {
            System.out.println("Size of " + folderName + " = " + size + " bytes");
        }
        // testing findWord

        System.out.println("Enter a folder name:");
        String folderName1 = keyboard.nextLine();
        System.out.println("Enter a word: ");
        String word = keyboard.nextLine();
        findWord(folderName1, word);

    }

    /**
     * findFile method
     * 
     * @param folder   The folder to look into
     * @param filename The file to find
     * @return The file found
     */
    public static String findFile(String folder, String filename) {
        System.out.println("Looking for " + filename + " in " + folder);
        File file = new File(folder);
        if (!file.exists()) {
            return "";
        }
        if (file.isFile()) {
            return "";
        }
        if (file.isDirectory()) {
            // get the contents of the folder
            File[] files = file.listFiles();
            for (File f : files) {
                if (f.isFile()) {
                    if (f.getName().equals(filename)) {
                        return f.getAbsolutePath();
                    }
                }
                if (f.isDirectory()) {
                    String found = findFile(f.getAbsolutePath(), filename);
                    if (!found.equals("")) {
                        return found;
                    }
                }
            }
        }
        return "";
    }

    // get size:
    /**
     * getSize method
     * 
     * @param folder The folder to get size from
     * @return the Total size of the folder in bytes
     */
    public static long getSize(String folder) {
        File file = new File(folder);
        long totalSize = 0;
        if (!file.exists()) {
            return 0;
        }
        if (file.isFile()) {
            return file.length();
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                totalSize += getSize(f.getAbsolutePath());
            }
        }
        return totalSize;
    }

    /**
     * findWord recursive method
     * 
     * @param folder The folder to look into
     * @param word   The word to search for
     *               no return value
     */
    public static void findWord(String folder, String word) {
        File file = new File(folder);
        if (!file.exists()) {
            System.out.println("Folder not found.");
        }
        if (file.isFile()) {
            int count = readFile(file.getAbsolutePath(), word);
            if (count != 0) {
                System.out.println(word + " appears " + count + " times in " + file.getAbsolutePath());
            }
        }
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                findWord(f.getAbsolutePath(), word);
            }
        }
    }

    /***
     * readFile method
     * 
     * @param filename The file to read from
     * @param word     The word to search for in the file
     * @return the number of occurrences of the word
     */
    public static int readFile(String filename, String word) {
        System.out.println("Looking for " + word + " inside the file " + filename);
        File file = new File(filename);
        int count = 0;
        try {
            Scanner read = new Scanner(file);
            while (read.hasNextLine()) {
                String line = read.nextLine();
                int index = line.indexOf(word);
                while (index != -1) {
                    count++;
                    index = line.indexOf(word, index + 1);
                }
            }

            read.close();
        } catch (FileNotFoundException e) {
            return 0;
        }
        return count;
    }

}