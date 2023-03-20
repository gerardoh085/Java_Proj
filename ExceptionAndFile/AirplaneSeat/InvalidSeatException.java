
/***
 * InvalidSeatException Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: January 31, 2023
 *          Last Date Modified: January 31, 2023
 */
public class InvalidSeatException extends Exception {
    // date members:
    private String message;

    /***
     * Default constructor with message
     */
    InvalidSeatException() {
        super("Invalid seat Number");
    }

    /***
     * Constructor with message
     * 
     * @param message The message to be displayed for the exception/error
     * @throws InvalidSeatException For invalid seat number
     *                              no return value
     */
    InvalidSeatException(String message) throws InvalidSeatException {
        super(message);
    }
}