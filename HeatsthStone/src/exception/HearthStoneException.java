package exception;

public class HearthStoneException extends Exception {
    public HearthStoneException() {
        super();
    }

    public HearthStoneException(String message) {
        super(message);
    }

    public HearthStoneException(String message, Throwable cause) {
        super(message, cause);
    }
}
