/***
 * Class to model the entity Person
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: January 23, 2023
 *          Last Date Modified: January 24, 2023
 */
public class Person {
    // data members
    protected String name;
    protected String address;
    protected String phone;
    protected String email;

    /***
     * Default constructor
     * no parameters
     * Initializes name, address, phone, and email to the string ""
     */
    public Person() {
        name = "";
        address = "";
        phone = "";
        email = "";
    }

    /***
     * Constructor for the Person class
     * 
     * @param name    name of the person
     * @param address address of the person
     * @param phone   phone number of the person
     * @param email   email of the person
     *                no return value
     */
    public Person(String name, String address, String phone, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    /***
     * Getter method for the name
     * no parameters
     * 
     * @return the value of the data member name of the person
     */
    public String getName() {
        return name;
    }

    /***
     * Getter method for the address
     * no parameters
     * 
     * @return the value of the data member address of the person
     */
    public String getAddress() {
        return address;
    }

    /***
     * Getter method for the phone number
     * no parameters
     * 
     * @return the value of the data member phone number of the person
     */
    public String getPhone() {
        return phone;
    }

    /***
     * Getter method for the email
     * no parameters
     * 
     * @return the value of the data member email of the person
     */
    public String getEmail() {
        return email;
    }

    /***
     * Setter method for the name
     * 
     * @param n sets the name of the person
     *          no return value
     */
    public void setName(String n) {
        this.name = n;
    }

    /**
     * Setter method for the address
     * 
     * @param a sets the address of the person
     *          no return value
     */
    public void setAddress(String a) {
        this.address = a;
    }

    /***
     * Setter method for the phone number
     * 
     * @param p sets the phone number of the person
     *          no return value
     */
    public void setPhone(String p) {
        this.phone = p;
    }

    /***
     * Setter method for the email
     * 
     * @param e sets the email of the person
     *          no return value
     */
    public void setEmail(String e) {
        this.email = e;
    }

    /***
     * Format information abuout the person into a string
     * no parameters
     * 
     * @return the string representation of the persons information
     */
    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nPhone: " + phone + "\nEmail: " + email;
    }

}