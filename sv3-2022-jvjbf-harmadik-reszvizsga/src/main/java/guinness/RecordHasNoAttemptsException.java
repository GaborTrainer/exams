package guinness;

public class RecordHasNoAttemptsException extends RuntimeException {

    public RecordHasNoAttemptsException(String message) {
        super(message);
    }
}