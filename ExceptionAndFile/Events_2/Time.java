/***
 * Time Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: February 6, 2023
 *          Last Date Modified: February 8, 2023
 */
public class Time {
    // Data members
    private int hours;
    private int minutes;

    /**
     * Default constructor
     * calls the super() function
     */
    public Time() {
        super();

    }

    /***
     * Constructor for the Time class
     * 
     * @param time The string representation of the time (HH:MM)
     * @throws InvalidDateTimeException
     *                                  no return value
     */
    public Time(String time) throws InvalidDateTimeException {
        this.hours = Integer.parseInt(time.substring(0, 2));
        this.minutes = Integer.parseInt(time.substring(3, 5));
    }

    /**
     * getter method for the hours
     * no parameters
     * 
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * getter method for the minutes
     * no parameters
     * 
     * @return the minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * setter method for the hours
     * 
     * @param hours Sets the hours
     *              no return value
     */
    public void setHours(int hours) throws InvalidDateTimeException {
        this.hours = hours;
    }

    /**
     * setter method for the minutes
     * 
     * @param minutes Sets the minutes
     *                no return value
     */
    public void setMinutes(int minutes) throws InvalidDateTimeException {
        this.minutes = minutes;
    }

    /**
     * toString method
     * no parameters
     * 
     * @return formatted time (HH:MM)
     */
    public String toString() {

        if (this.hours <= 9 && this.minutes >= 10) {
            return "0" + this.hours + ":" + this.minutes;
        } else if (this.hours <= 9 && this.minutes <= 9) {
            return "0" + this.hours + ":" + "0" + this.minutes;
        } else if (this.hours >= 10 && this.minutes <= 9) {
            return this.hours + ":" + "0" + this.minutes;
        } else {
            return this.hours + ":" + this.minutes;
        }

    }
}