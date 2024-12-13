package oncall.exception;

public class DuplicatedAssignmentException extends IllegalArgumentException {
    public DuplicatedAssignmentException() {
        super(ErrorMessage.ASSIGNED_ONCE_EACH.getMessage());
    }
}
