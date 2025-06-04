package src.fr.training.exceptions.library;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] books = {"Lord of the Rings", "Fire and Blood", "What We Owe To Each Other"};

        try {
            System.out.printf("Search book index (between 0 and %s): ",  books.length - 1);
            int searchIndex = Integer.parseInt(scanner.nextLine());
            String foundBook =  books[searchIndex];
            System.out.printf("Book found: [index= %s, title= %s]%n", searchIndex, foundBook);
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid index (number)");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.printf("Please enter an index corresponding to a book (between '0' and '%s')%n", books.length - 1);
        } finally {
            scanner.close();
        }
    }
}
