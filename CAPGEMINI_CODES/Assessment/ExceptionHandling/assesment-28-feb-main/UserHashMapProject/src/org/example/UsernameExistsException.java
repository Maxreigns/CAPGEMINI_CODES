package src.org.example;

public class UsernameExistsException extends RuntimeException {

    public UsernameExistsException(String message) {
        super(message);
    }
}