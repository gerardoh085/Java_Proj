/***
 * Appointment Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: January 28, 2023
 *          Last Date Modified: January 29, 2023
 */

public class Appointment extends Event {
    // Data Members
    private String contact;

    /***
     * Default constructor
     * no parameters
     * no return value
     */
    public Appointment() {
        super();
        contact = "";
    }

    /**
     * Constructor for the Appointment class
     * 
     * @param description Description of the Appointment
     * @param location    Location of the Appointment
     * @param date        Date of the Appointment
     * @param time        Time of the Appointment
     * @param contact     The contact information for the Appointment
     *                    no return value
     */
    public Appointment(String description, String location,
            String date, String time, String contact) {
        super(description, location, date, time);
        this.contact = contact;
    }

    /**
     * Getter method for contact
     * no parameters
     * 
     * @return The contact name
     */
    public String getContact() {
        return contact;
    }

    /**
     * Setter method for setting the contact information
     * 
     * @param contact The contact name of the Appointment
     */
    public void setContact(String contact) {
        this.contact = contact;
    }

    /**
     * toString method for printing a formatted string representation of the data
     * members
     * no parameters
     * no return value
     */
    public String toString() {
        String formatter = String.format("%-15s %-10s %-10s", "Appointment", super.toString(), contact);
        return formatter;
    }

}
