/***
 * Date Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: February 6, 2023
 *          Last Date Modified: February 8, 2023
 */
public class Date {
    // data members
    private int month;
    private int day;
    private int year;

    /***
     * Default constructor
     * calls super() function
     */
    public Date() {
        super();
    }

    /**
     * Constructor for the Date class
     * 
     * @param date The string representation of the date (MM/DD/YYYY)
     *             no return value
     */
    public Date(String date) {
        month = Integer.parseInt(date.substring(0, 2));
        day = Integer.parseInt(date.substring(3, 5));
        year = Integer.parseInt(date.substring(6, 10));
    }

    /**
     * getter method for the month
     * no parameters
     * 
     * @return the month
     */
    public int getMonth() {
        return month;
    }

    /**
     * getter method for the day
     * no parameters
     * 
     * @return the day
     */
    public int getDay() {
        return day;
    }

    /**
     * getter method for the year
     * no parameters
     * 
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * setter method for the month (set the month)
     * 
     * @param month The month to set to
     * @throws InvalidDateTimeException
     *                                  no return value
     */
    public void setMonth(int month) throws InvalidDateTimeException {
        this.month = month;
    }

    /**
     * setter method for the day (set the day)
     * 
     * @param day The day to set to
     * @throws InvalidDateTimeException
     *                                  no return value
     */
    public void setDay(int day) throws InvalidDateTimeException {
        this.day = day;
    }

    /**
     * setter method for the year (set the year)
     * 
     * @param year The year to set to
     * @throws InvalidDateTimeException
     *                                  no return value
     */
    public void setYear(int year) throws InvalidDateTimeException {
        this.year = year;
    }

    /**
     * toString method sets the date in proper format (MM/DD/YYYY)
     * no parameters
     * 
     * @return formatted Date
     */
    public String toString() {
        if (this.month <= 9 && this.day >= 10) {
            return "0" + month + "/" + day + "/" + year;
        } else if (this.month <= 9 && this.day <= 9) {
            return "0" + month + "/" + "0" + day + "/" + year;
        } else if (this.month >= 10 && this.day <= 9) {
            return month + "/" + "0" + day + "/" + year;
        } else {
            return month + "/" + day + "/" + year;
        }
    }
}