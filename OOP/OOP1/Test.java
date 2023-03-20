/***
 * Test Class
 * 
 * @author Gerardo Hernandez Macoto
 * @version 0.1
 *          Date of creation: January 23, 2023
 *          Last Date Modified: January 24, 2023
 */
public class Test {
    public static void main(String[] args) {
        // set the size
        int size = 4;
        // Create Person object
        Person people[] = new Person[size];
        // set the Person, Student, Employee, and Faculty objects
        people[0] = new Person(
                "Helen Brown",
                "222 10th Street Bethlehem",
                "610-334-2288",
                "hbrown@gmail.com");
        people[1] = new Student("Paul Leister",
                "972 4th Street Allentown",
                "610-331-7177",
                "pleister@gmail.com",
                12345,
                "CSE");
        people[2] = new Employee(
                "Beth Down",
                "234 Main Street Philadelphia",
                "484-222-4433",
                "bdown@gmail.com",
                33442,
                "Systems Administrator",
                75000.00);
        people[3] = new Faculty(
                "Mark Jones",
                "21 Orchid Street Bethlehem",
                "610-333-2211",
                "mjones@gmail.com",
                22222,
                "Faculty",
                100000.00,
                "Associate Professor");

        // original list:
        System.out.println();
        System.out.println("Original List:");
        printArray(people);
        System.out.println();
        // sorted list:
        System.out.println("Sorted List: ");
        selectionSort(people);
        printArray(people);

    }

    /***
     * Prints the list of people
     * 
     * @param list for the list of people
     *             no return value
     */
    public static void printArray(Person[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i].toString() + "\n");
        }
    }

    /**
     * Sort function (sort by name)
     * 
     * @param list for the list of people to sort
     *             no return value
     */
    public static void selectionSort(Person[] list) {
        for (int i = 0; i < list.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < list.length; j++)
                if (list[j].getName().compareTo(list[minIndex].getName()) < 0)
                    minIndex = j;
            Person temp = list[i];
            list[i] = list[minIndex];
            list[minIndex] = temp;
        }
    }

}
