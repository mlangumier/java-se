package src.fr.training.exceptions.string_analyzer;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter your operation: ");
            String input = scanner.nextLine().trim();

            int result = solveOperation(input);
            System.out.println("Operation: " + input + " = " + result);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Don't forget to add spaces between the numbers and operators (ex: 5 + 7)");
        } catch(IllegalArgumentException e) {
            System.out.println("Argument Exception: " + e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.printf("Error: %s (type: %s)%n", e.getMessage(), e.getClass());
        }
    }

    private static int solveOperation(String input) {
        String[] inputArray = input.split("\\s+");

        if (inputArray.length != 3) {
            throw new IllegalArgumentException("Your operation must contain two numbers and one operator.");
        }

        String operator = inputArray[1];
        int firstNbr = Integer.parseInt(inputArray[0]);
        int secondNbr = Integer.parseInt(inputArray[2]);
        int result;

        switch (operator) {
            case "+" -> result = firstNbr + secondNbr;
            case "-" -> result = firstNbr - secondNbr;
            case "*", "x" -> result = firstNbr * secondNbr;
            case "/", ":" -> result = firstNbr / secondNbr;
            default -> throw new IllegalArgumentException("Unknown operator: " + operator);
        }

        return result;
    }
}
