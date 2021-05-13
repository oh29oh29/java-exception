package oh29oh29.study03;

public class IncorrectFileNameCheckedException extends Exception {

    public IncorrectFileNameCheckedException(String errorMessage) {
        super(errorMessage);
    }

    /**
     * This is how we can use custom exceptions without losing the root cause from which they occurred.
     */
    public IncorrectFileNameCheckedException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }
}