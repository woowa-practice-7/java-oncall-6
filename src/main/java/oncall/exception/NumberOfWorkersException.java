package oncall.exception;

public class NumberOfWorkersException extends IllegalArgumentException {
    public NumberOfWorkersException() {
        super(ErrorMessage.INVALID_NUM_OF_WORKERS.getMessage());
    }
}
