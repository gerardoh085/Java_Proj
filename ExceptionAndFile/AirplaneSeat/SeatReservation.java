
/***
 * SeatReservation Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: January 31, 2023
 *          Last Date Modified: January 31, 2023
 */
import java.util.Scanner;

public class SeatReservation extends Airplane {
    /**
     * menu for selection options
     */
    public static void menu() {
        System.out.println("Please select an operation:");
        System.out.println("1: Reserve a seat");
        System.out.println("2: Free a seat");
        System.out.println("3: Quit");
    }

    /**
     * The operation method to perform updates to seat map
     * 
     * @param plane The Airplane object to do operations on
     *              no return value
     */
    public static void operation(Airplane plane) {
        int choice;
        do {
            menu();
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice) {
                case 1:
                    // Reserve a seat
                    // choose a seat number
                    System.out.println("Enter a seat number: ");
                    String seatNum = scan.next();
                    try {
                        Boolean check = plane.reserveSeat(seatNum);
                        if (check) {
                            System.out.println("Seat number " + seatNum + " has been successfully reserved!");
                        } else {
                            System.out.println("Seat number " + seatNum + " is occupied!");
                        }
                        plane.toString();
                    } catch (InvalidSeatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    // Free a seat
                    System.out.println("Enter a seat number: ");
                    String seatNumber = scan.next();
                    try {
                        Boolean check = plane.freeSeat(seatNumber);
                        if (check) {
                            System.out.println("Seat number " + seatNumber + " has been freed!");
                        } else {
                            System.out.println("Seat number " + seatNumber + " is already freed!");
                        }
                        plane.toString();
                    } catch (InvalidSeatException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    // Quit
                    System.out.println("Thank you for using my airplane seat reservation program!");
                    plane.saveMap("seatmap.txt");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        } while (choice != 3);
    }

    public static void main(String[] args) {
        String filename = "seatmap.txt";
        Airplane plane = new Airplane(filename); // create and initialize Airplane object
        plane.toString();
        operation(plane);

    }
}