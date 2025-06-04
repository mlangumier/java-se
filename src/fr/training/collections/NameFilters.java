package src.fr.training.collections;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * Names filters - Working with TreeSet
 */
public class NameFilters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeSet<String> names = new TreeSet<>();

        System.out.println();
        System.out.println("--- Name filters ---");

        enterNames(scanner, names, 5);

        displayNames(names);
        scanner.close();
    }

    /**
     * Display the names from the list
     * @param names List of names
     */
    public static void displayNames(TreeSet<String> names) {
            System.out.println("Names: " + names);
    }

    /**
     * Add a list of names with user input
     * @param scanner Allows user input to add names
     * @param names List of names
     * @param nbrNames Number of names the user needs to write
     */
    public static void enterNames(Scanner scanner, TreeSet<String> names, int nbrNames) {
        int counter = nbrNames;

        do {
            System.out.print("Add a name: ");
            names.add(scanner.nextLine().toLowerCase());
            counter--;
        } while (counter > 0);
    }

}
