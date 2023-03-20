
/***
 * Test Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: January 28, 2023
 *          Last Date Modified: January 29, 2023
 */

import java.util.Scanner;

public class Test {
    /**
     * prints the Event object
     * 
     * @param list The event object array
     *             no return value
     */
    public static void printEvents(Event[] list) {
        String formatter = String.format("%-15s %-17s %-20s %-13s %-8s %-17s %-10s", "Type", "Description",
                "Location ",
                "Date", "Time",
                "Contact/Host",
                "Guests");
        System.out.println(formatter);
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i].toString() + "\n");
        }
    }

    /**
     * The event object array sorted by the location
     * 
     * @param list The event object array
     *             no return value
     */
    public static void sortEvents(Event[] list) {
        for (int i = 1; i < list.length; i++) {
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
     * @return The index of the event object description
     */
    public static int findEvent(Event[] list, String descr) {
        for (int i = 0; i < list.length; i++) {
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
     * @return returns the arary with all the event locations
     */
    public static Event[] findEvents(Event[] list, String location) {
        int valid = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i].getLocation().matches(location)) {
                valid++;
            }
        }
        int count = 0;
        Event[] array = new Event[valid];
        for (int i = 0; i < list.length; i++) {
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
     *             no return value
     */
    public static void options(Event[] list) {
        Scanner scan = new Scanner(System.in);
        int choice;
        do {
            menu();
            choice = scan.nextInt();

            switch (choice) {
                case 1:
                    // View all events
                    printEvents(list);
                    break;
                case 2:
                    // search event by description
                    System.out.println("Enter a description: ");
                    String resp = scan.next();
                    int output = findEvent(list, resp);
                    if (output == -1) {
                        System.out.println("No event was found with description: " + resp);
                    } else {
                        System.out.println("Event Found: " + list[output].toString());
                    }
                    break;
                case 3:
                    // search event by location
                    System.out.println("Enter a location: ");
                    String loc = scan.next();
                    Event[] arr = findEvents(list, loc);
                    if (arr == null) {
                        System.out.println("No event found at " + loc);
                    } else {
                        printEvents(arr);
                    }
                    break;
                case 4:
                    // sort events by location
                    sortEvents(list);
                    printEvents(list);
                    break;
                case 5:
                    // exit program
                    System.exit(0);
                    break;
                default:

                    break;

            }
        } while (choice != 5);

        scan.close();
    }

    public static void main(String[] args) {
        int size = 10;
        Event[] events = new Event[size];
        events[0] = new Appointment("Dentist", "Lehigh Dentists", "01/26/2023", "10:30", "Beth Clark");
        events[1] = new Meeting("Science Club", "PA-220", "02/03/2023", "16:30", "Will Johns", 25);
        events[2] = new Meeting("Movie Club", "PA-220", "01/31/2023", "17:00", "Grace Williams", 10);

        events[3] = new Appointment("Instructor", "PA-254", "01/30/2023", "11:15", "Mark Jones");

        events[4] = new Meeting("Provost", "Memorial Building", "05/05/2023", "14:30", "Lisa Zuppe", 100);

        events[5] = new Meeting("Group work", "Zoom", "02/07/2023", "18:45", "Jack Taylor", 5);

        events[6] = new Appointment("Doctor", "Lehigh Doctors", "04/22/2023", "13:45", "Kathy Bell");

        events[7] = new Meeting("Programming Club", "PA-220", "03/15/2023", "19:00", "Billy Steward", 20);

        events[8] = new Appointment("Advising", "PA-252", "03/11/2023", "12:15", "Sharon Kraft");

        events[9] = new Appointment("Bank Account", "Wells Fargo", "03/25/2023", "10:30", "Sarah Thomson");

        options(events);
    }

}
