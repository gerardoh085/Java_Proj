/***
 * Event Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: February 6, 2023
 *          Last Date Modified: February 8, 2023
 */
public class Event {
    // Data Members
    private String description;
    private String location;
    private Date date;
    private Time time;

    /**
     * Default constructor
     * no parameters
     * no return value
     */
    public Event() {
        description = "";
        location = "";
        date = new Date();
        time = new Time();
    }

    /**
     * Constructor for the Event class
     * 
     * @param description Description of the event
     * @param location    Location of the event
     * @param date        Date of the event
     * @param time        Time of the event
     *                    no return value
     * @throws InvalidDateTimeException
     */
    public Event(String description, String location, String date, String time) throws InvalidDateTimeException {
        this.description = description;
        this.location = location;
        this.date = new Date(date);
        this.time = new Time(time);
    }

    /**
     * Getter Method for retreiving description of the event
     * no parameters
     * 
     * @return The description of the event
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter method for retreiving location of the event
     * no parameters
     * 
     * @return The location of the event
     */
    public String getLocation() {
        return location;
    }

    /**
     * Getter method for retreiving Date of the event
     * no parameters
     * 
     * @return The date of the event
     */
    public Date getDate() {
        return date;
    }

    /**
     * Getter method for retreiving time of the event
     * no parameters
     * 
     * @return The time of the event
     */
    public Time getTime() {
        return time;
    }

    /**
     * Setter Method for setting the description of the event
     * no parameters
     * 
     * @param description The description of the event
     *                    no return value
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Setter method for setting the location of the event
     * no parameters
     * 
     * @param location The location of the event
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Setter method for setting the Date of the event
     * no parameters
     * 
     * @param date The date of the event
     */
    public void setDate(String date) {
        this.date = new Date(date);
    }

    /**
     * Setter method for setting the time of the event
     * no parameters
     * 
     * @param time The time of the event
     * @throws InvalidDateTimeException
     */
    public void setTime(String time) throws InvalidDateTimeException {
        this.time = new Time(time);
    }

    /**
     * toString method for printing a formatted string representation of the data
     * members
     * no parameters
     * no return value
     */
    public String toString() {
        String formatter = String.format("%-20s %-22s %-15s %-8s", description, location, date, time);
        return formatter;
    }

}