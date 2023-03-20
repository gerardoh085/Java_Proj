
/***
 * Test Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: February 6, 2023
 *          Last Date Modified: February 8, 2023
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {
    /**
     * prints the Event object
     * 
     * @param list The event object array
     * @param amnt The number of elements in the event array
     *             no return value
     */
    public static void printEvents(Event[] list, int amnt) {

        String formatter = String.format("%-15s %-20s %-22s %-15s %-8s %-17s %-10s", "Type", "Description",
                "Location ",
                "Date", "Time",
                "Contact/Host",
                "Guests");
        System.out.println(formatter);
        for (int i = 0; i < amnt; i++) {
            System.out.print(list[i].toString() + "\n");
        }
    }

    /**
     * The event object array sorted by the location
     * 
     * @param list The event object array
     * @param amnt The number of elements in the event array
     *             no return value
     */
    public static void sortEvents(Event[] list, int amnt) {
        for (int i = 1; i < amnt; i++) {
            int j = i;
            Event currentVal = list[i];
            while (j > 0 && currentVal.getLocation().compareTo(list[j - 1].getLocation()) < 0) {
                list[j] = list[j - 1];
                j--;
            }
            list[j] = currentVal;
        }
    }

    /**
     * Finds the event description
     * 
     * @param list  The event object array
     * @param descr The event object description
     * @param amnt  The number of elements in the event array
     * @return The index of the event object description
     */
    public static int findEvent(Event[] list, String descr, int amnt) {
        for (int i = 0; i < amnt; i++) {
            if (list[i].getDescription().matches(descr)) {
                return i;
            }
        }
        return -1; // placeholder
    }

    /**
     * Finds one or multiple event location and stores it in an event array object
     * 
     * @param list     The event object array
     * @param location The location of the event
     * @param amnt     The number of elements in the event array
     * @return returns the arary with all the event locations
     */
    public static Event[] findEvents(Event[] list, String location, int amnt) {
        int valid = 0;
        for (int i = 0; i < amnt; i++) {
            if (list[i].getLocation().matches(location)) {
                valid++;
            }
        }
        int count = 0;
        Event[] array = new Event[valid];
        for (int i = 0; i < amnt; i++) {
            if (list[i].getLocation().matches(location)) {
                array[count] = list[i];
                count++;
            }
        }

        if (array.length != 0) {
            return array;
        } else {
            return null;
        }
    }

    /***
     * Prints out options to select from
     * no parameters
     * no return value
     */
    public static void menu() {
        System.out.println("Select an operation:");
        System.out.println("1: view all event");
        System.out.println("2: search event by description");
        System.out.println("3: search events by location");
        System.out.println("4: sort events by location");
        System.out.println("5: exit");
    }

    /***
     * A method to select from the menu
     * 
     * @param list The event array object
     * @param amnt The number of elements in the event array
     *             no return value
     */
    public static void options(Event[] list, int amnt) {
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            menu();
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    // View all events
                    printEvents(list, amnt);
                    break;
                case 2:
                    // search event by description
                    System.out.println("Enter a description: ");
                    scan.nextLine();
                    String resp = scan.nextLine();
                    int output = findEvent(list, resp, amnt);
                    if (output == -1) {
                        System.out.println("No event was found with description: " + resp);

                    } else {
                        System.out.println("Event Found: " + list[output].toString());
                    }
                    break;
                case 3:
                    // search event by location
                    System.out.println("Enter a location: ");
                    scan.nextLine();
                    String loc = scan.nextLine();
                    Event[] arr = findEvents(list, loc, amnt);
                    if (arr == null) {
                        System.out.println("No event found at " + loc);
                    } else {
                        printEvents(arr, arr.length);
                    }
                    break;
                case 4:
                    // sort events by location
                    sortEvents(list, amnt);
                    printEvents(list, amnt);
                    break;
                case 5:
                    // exit program
                    System.exit(0);
                    break;
                default:
                    System.out.println("Default!");
                    break;

            }
        } while (choice != 5);

        scan.close();
    }

    public static void main(String[] args) throws InvalidDateTimeException {
        int size = 50;
        Event[] events = new Event[size];

        String filename = "events.txt";

        int num_events = readEvents(events, filename);

        options(events, num_events);

    }

    /***
     * readEvents function reads the events from the specified file
     * 
     * @param events   Store the events in the events array object
     * @param filename The file reading from
     * @return The number of events in the file
     * @throws InvalidDateTimeException Invalid Date or Time throws an exception
     */
    public static int readEvents(Event[] events, String filename) throws InvalidDateTimeException {
        File file = new File("./events.txt");
        // events = new Event[50];
        int counter = 0;
        try {
            Scanner readFile = new Scanner(file);
            while (readFile.hasNextLine()) {

                String type, description, location, date, time, contact, host;
                int guests;

                type = readFile.nextLine();
                description = readFile.nextLine();
                location = readFile.nextLine();
                date = readFile.nextLine();
                time = readFile.nextLine();

                if (type.equals("appointment")) {
                    contact = readFile.nextLine();
                    events[counter] = new Appointment(description, location, date, time,
                            contact);
                } else if (type.equals("meeting")) {
                    host = readFile.nextLine();
                    guests = readFile.nextInt();
                    readFile.nextLine();
                    events[counter] = new Meeting(description, location, date, time, host,
                            guests);
                } else {
                    readFile.close();
                }

                counter++;
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return counter;
    }

}
