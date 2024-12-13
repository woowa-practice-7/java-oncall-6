package oncall.exception;

public class GeneralException extends RuntimeException {
    public GeneralException() {
        super(ErrorMessage.INVALID_INPUT.getMessage());
    }
}
