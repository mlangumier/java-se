package src.fr.training.exceptions.atm.exceptions;

public class AccountBalanceTooLowException extends Exception {
    public AccountBalanceTooLowException(String message) {
        super(message);
    }
}
