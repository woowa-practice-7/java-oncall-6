package oncall.exception;

public class NameLengthException extends IllegalArgumentException {
    public NameLengthException() {
        super(ErrorMessage.INVALID_NAME_LENGTH.getMessage());
    }
}
