package src.fr.training.exceptions.atm;

import src.fr.training.exceptions.atm.exceptions.AccountBalanceTooLowException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int accountBalance = 100;

    public static void main(String[] args) throws AccountBalanceTooLowException {

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("How much would you like to withdraw: ");
            int withdrawAmount = scanner.nextInt();
            withdraw(withdrawAmount);

            accountBalance -= withdrawAmount;
            System.out.printf("Amount withdrawn: %s€. New account balance: %s€%n", withdrawAmount, accountBalance);
        } catch (InputMismatchException e) {
            System.out.println("Please enter a valid number.");
        } catch (AccountBalanceTooLowException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.err.printf("Error: %s (from: %s)%n", e.getMessage(), e.getClass());
        }


    }

    private static void withdraw(int amount) throws AccountBalanceTooLowException {
        if (amount % 10 != 0 || amount <= 0) {
            throw new IllegalArgumentException("Amount must be a multiple of '10' and not '0'");
        }

        if (amount > accountBalance) {
            throw new AccountBalanceTooLowException(
                    String.format("Cannot withdraw requested amount: %s€ (account balance too low: %s€).", amount, accountBalance)
            );
        }

    }
}
