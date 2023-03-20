/***
 * Class to model the entity Employee
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: January 23, 2023
 *          Last Date Modified: January 24, 2023
 */
public class Employee extends Person {
    // Data Members
    private int id;
    private String position;
    private double salary;

    /***
     * Default constructor
     * No parameters
     * returns nothing
     */
    public Employee() {
        super();
        id = 0;
        position = "";
        salary = 0;
    }

    /***
     * Constructor for the Employee Class
     * 
     * @param name     of the employee
     * @param address  of the employee
     * @param phone    number of the employee
     * @param email    of the employee
     * @param id       of the employee
     * @param position of the employee
     * @param salary   of the employee
     *                 no return value
     */
    public Employee(String name, String address, String phone,
            String email, int id, String position, double salary) {
        super(name, address, phone, email);
        this.id = id;
        this.position = position;
        this.salary = salary;
    }

    /***
     * Getter function for obtaining the ID
     * no parameters
     * 
     * @return id of the employee
     */
    public int getID() {
        return id;
    }

    /***
     * Getter function for the employee position
     * no parameters
     * 
     * @return position of the employee
     */
    public String getPosition() {
        return position;
    }

    /***
     * Getter method for employee salary
     * no parameters
     * 
     * @return salary of the employee
     */
    public double getSalary() {
        return salary;
    }

    /***
     * Setter Method for setting the employee ID
     * 
     * @param id set the employee ID
     *           no return value
     */
    public void setID(int id) {
        this.id = id;
    }

    /***
     * Setter Method for setting the employee position
     * 
     * @param position set the employee position
     *                 no return value
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /***
     * Setter Method for setting the employee salary
     * 
     * @param salary set the employee salary
     *               no return value
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /***
     * Formats the information of the employee
     * no parameters
     * 
     * @return formatted information of the employee (ID, Position, Salary, etc)
     */
    public String toString() {
        String s = String.format("%s\nID: %d\nPosition: %s\nSalary: $%.2f", super.toString(), id, position, salary);
        return s;
    }

}