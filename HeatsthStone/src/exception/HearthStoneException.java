package exception;

public class HearthStoneException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7807490394249164975L;

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
