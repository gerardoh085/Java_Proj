/***
 * Class to model the entity Faculty
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: January 23, 2023
 *          Last Date Modified: January 24, 2023
 */
public class Faculty extends Employee {
    private String rank;

    /***
     * Default constructor
     * no parameters
     * no return value
     */
    public Faculty() {
        super();
        rank = "";
    }

    /***
     * Construct of the Faculty class
     * 
     * @param name     of the Faculty member
     * @param address  of the Faculty member
     * @param phone    number of the Faculty member
     * @param email    of the Faculty member
     * @param id       of the Faculty member
     * @param position of the Faculty member
     * @param salary   of the Faculty member
     * @param rank     of the Faculty member
     *                 no return value
     */
    public Faculty(String name, String address, String phone,
            String email, int id, String position,
            double salary, String rank) {
        super(name, address, phone, email, id, position, salary);
        this.rank = rank;
    }

    /***
     * Getter method for the Rank of the Faculty member
     * no parameters
     * 
     * @return rank of the Faculty member
     */
    public String getRank() {
        return rank;
    }

    /***
     * Setter method for setting the Rank of the Faculty member
     * 
     * @param rank of the Faculty member
     *             no return value
     */
    public void setRank(String rank) {
        this.rank = rank;
    }

    /***
     * String method for formatting Faculty member information
     * 
     * @return Formatted String of the Faculty Member
     */
    public String toString() {
        return String.format("%s \nRank%s", super.toString(), rank);
    }

}
