/***
 * Meeting Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: February 6, 2023
 *          Last Date Modified: February 8, 2023
 */
public class Meeting extends Event {
    // data members
    private String host;
    private int guests;

    /***
     * Default Constructor
     * no parameters
     * no return value
     */
    public Meeting() {
        super();
        host = "";
        guests = 0;
    }

    /**
     * Constructor for Meeting class
     * 
     * @param description Meeting description
     * @param location    Meeting location
     * @param date        Date of meeting
     * @param time        Time of meeting
     * @param host        host of meeting
     * @param guests      Number of guests for the meeting
     *                    no return value
     */
    public Meeting(String description, String location, String date, String time, String host, int guests)
            throws InvalidDateTimeException {
        super(description, location, date, time);
        this.host = host;
        this.guests = guests;
    }

    /**
     * Getter method for retreiving host information
     * no parameters
     * 
     * @return The host name
     */
    public String getHost() {
        return host;
    }

    /**
     * Getter method for retreiving guest information
     * no parameters
     * 
     * @return The number of guests
     */
    public int getGuests() {
        return guests;
    }

    /**
     * Setter method for setting the host name
     * 
     * @param host The host name
     *             no return value
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Setter method for setting the number of guests
     * 
     * @param guests The number of guests
     *               no return value
     */
    public void setGuests(int guests) {
        this.guests = guests;
    }

    /**
     * toString method for printing a formatted string representation of the data
     * members
     * no parameters
     * no return value
     */
    public String toString() {
        String formatter = String.format("%-15s %-10s %-17s %d", "Meeting", super.toString(), host, guests);
        return formatter;
    }

}
