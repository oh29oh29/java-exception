package oh29oh29.study03;

public class IncorrectFileExtensionUncheckedException extends RuntimeException {

    public IncorrectFileExtensionUncheckedException(String errorMessage) {
        super(errorMessage);
    }

    public IncorrectFileExtensionUncheckedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
