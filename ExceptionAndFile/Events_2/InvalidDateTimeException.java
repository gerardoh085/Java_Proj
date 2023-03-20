/***
 * InvalidDateTimeException Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: February 6, 2023
 *          Last Date Modified: February 8, 2023
 */
public class InvalidDateTimeException extends Exception {
    /**
     * Default Constructs a new InvalidDateTimeException
     */
    public InvalidDateTimeException() {
        super();
    }

    /**
     * Invalid DateTimeException constructor
     * 
     * @param message The error message for invalid DateTimeException
     *                no return value
     */
    public InvalidDateTimeException(String message) {
        super(message);
    }

}