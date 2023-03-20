/***
 * Class to model the entity Student
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: January 23, 2023
 *          Last Date Modified: January 24, 2023
 */
public class Student extends Person {
    // Data Members
    private int id;
    private String major;

    /***
     * Default constructor
     * no parameters
     * no return value
     * calls super(), sets id to '0' and major to the string ""
     */
    public Student() {
        super();
        id = 0;
        major = "";
    }

    /***
     * Constructor of the Student class
     * 
     * @param name    of the Student
     * @param address of the Student
     * @param phone   number of the Student
     * @param email   of the Student
     * @param id      of the Student
     * @param major   of the Student
     */
    public Student(String name, String address, String phone, String email,
            int id, String major) {
        super(name, address, phone, email);
        this.id = id;
        this.major = major;
    }

    /***
     * Getter method for the Student ID
     * no parameters
     * 
     * @return of the Student
     */
    public int getID() {
        return id;
    }

    /***
     * Getter method for the Student Major
     * no parameters
     * 
     * @return of the Student
     */
    public String getMajor() {
        return major;
    }

    /***
     * Setter method for setting the Student ID
     * 
     * @param id of the Student
     *           no return value
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Setter method for setting the Student Major
     * 
     * @param major of the Student
     *              no return value
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /***
     * String method for setting the Student information as a String
     * no parameters
     * 
     * @return formatted string representation of the Student information
     */
    public String toString() {
        // super.toString() + "\nID: " + id + "\nMajor: " + major;
        return String.format("%s \nID: %d \nMajor: %s", super.toString(), id, major);
    }

}
