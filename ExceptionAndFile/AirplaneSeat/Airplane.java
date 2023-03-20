
/***
 * Airplane Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: January 31, 2023
 *          Last Date Modified: January 31, 2023
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;

public class Airplane {
    // data members:
    private char seatMap[][];

    /***
     * Default constructor
     * no parameters
     * no return value
     * Initializes the 2D array
     */
    public Airplane() {
        seatMap = new char[9][8];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                seatMap[i][j] = '.';
            }
        }
    }

    /***
     * Constructor for the Airplane class
     * no parameters
     * no return value
     */
    public Airplane(String filename) {
        seatMap = new char[9][8];
        readMap(filename);
    }

    /***
     * read map from file
     * 
     * @param filename The file to read airplane data from
     *                 no return value
     */
    private void readMap(String filename) {

        File file = new File(filename); // create a file object
        try {
            Scanner readFile = new Scanner(file);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 8; j++) {
                    seatMap[i][j] = readFile.next().charAt(0);
                }
            }
            readFile.close();
        } catch (FileNotFoundException e) {

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 8; j++) {
                    seatMap[i][j] = '.';
                }
            }

        }
    }

    /**
     * check seat number boolean method
     * 
     * @param seatNumber The seat number to check if it's occupied
     * @return true if the given seat number is valid, throws an exception otherwise
     * @throws InvalidSeatException For invalid seat number
     */
    private Boolean checkSeatNumber(String seatNumber) throws InvalidSeatException {

        if (seatNumber.matches("[1-9][A-H]")) {
            return true;
        }
        throw new InvalidSeatException("Invalid seat number (row[1-9]column[A-H]). Please try again!");
    }

    /***
     * reserve seat boolean method - checks if seat is reserved
     * 
     * @param seatNumber Seat number to reserve
     * @return true if the given seat number is reserved, false otherwise
     * @throws InvalidSeatException For invalid seat number
     */
    public Boolean reserveSeat(String seatNumber) throws InvalidSeatException {
        if (checkSeatNumber(seatNumber)) { // valid seat number
            // seatNumber = "2G";
            char rowc = seatNumber.charAt(0); // first character (row)
            char colc = seatNumber.charAt(1); // second character (col)
            int row = rowc - '1';
            int col = colc - 'A';
            if (seatMap[row][col] == 'X') {
                return false;
            } else {
                seatMap[row][col] = 'X';
                return true;
            }
        }
        return false;
    }

    /***
     * free seat - method to free an occupied seat
     * 
     * @param seatNumber Seat number to free
     * @return true if seat was freed, false otherwise
     * @throws InvalidSeatException For invalid seat number
     */
    public Boolean freeSeat(String seatNumber) throws InvalidSeatException {
        if (checkSeatNumber(seatNumber)) { // valid seat number
            // seatNumber = "2G";
            char rowc = seatNumber.charAt(0); // first character (row)
            char colc = seatNumber.charAt(1); // second character (col)
            int row = rowc - '1';
            int col = colc - 'A';
            if (seatMap[row][col] == '.') {
                return false;
            } else {
                seatMap[row][col] = '.';
                return true;
            }
        }
        return false;
    }

    /**
     * save map to a file
     * 
     * @param filename The file name to save to
     *                 no return value
     */
    public void saveMap(String filename) {
        File file = new File(filename);
        try {
            PrintWriter writeFile = new PrintWriter(file);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 8; j++) {
                    writeFile.print(seatMap[i][j] + "\t");
                }
                writeFile.println();
            }
            writeFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Cannot write to " + filename);
        }
    }

    /***
     * toString method to output seat map
     * no paramters
     * no return value
     */
    public String toString() {
        String output = "";
        System.out.println("\tA\tB\tC\tD\tE\tF\tG\tH");
        for (int i = 0; i < 9; i++) {
            System.out.print(i + 1 + "\t");
            for (int j = 0; j < 8; j++) {
                System.out.print(seatMap[i][j] + "\t");
            }
            System.out.println();
        }
        return output;
    }

}