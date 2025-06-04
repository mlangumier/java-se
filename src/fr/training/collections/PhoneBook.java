package src.fr.training.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Phonebook manager - Working with HashMap
 */
public class PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> contacts = new HashMap<>();

        System.out.println();
        System.out.println("--- Phone Book Manager ---");

        createContact(scanner, contacts);
        createContact(scanner, contacts);

        System.out.println();
        showContactsList(contacts);

        System.out.println();
        searchContact(scanner, contacts);

        scanner.close();
    }

    /**
     * Display the contact list
     * @param contacts List of contacts
     */
    public static void showContactsList(HashMap<String, String> contacts) {
        for (Map.Entry<String, String> contact: contacts.entrySet()) {
            System.out.printf("%s (%s)%n", contact.getKey(), contact.getValue());
        }
    }

    /**
     * Create a contact with user input and add them to the list
     * @param contacts List of contacts
     */
    public static void createContact(Scanner scanner, HashMap<String, String> contacts) {
        String name;
        String number;

        System.out.println("\n-- New contact --");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Number: ");
        number = scanner.nextLine();

        contacts.put(name, number);
    }

    /**
     * Search a contact's number with its name via user input
     * @param scanner Allows user input to add names
     * @param contacts List of contacts
     */
    public static void searchContact(Scanner scanner, HashMap<String, String> contacts) {
        System.out.print("Search contact name: ");
        String search = scanner.nextLine();

        // .getOrDefault() allows us to define a message if the item is not found (better than IF ELSE)
        System.out.printf("Found: %s (%s)%n", search, contacts.getOrDefault(search, "Not found"));
    }
}
