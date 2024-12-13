package oncall.exception;

public enum ErrorMessage {
    INVALID_NAME_LENGTH("\n[ERROR] 닉네임은 최대 5글자입니다. 다시 입력해 주세요."),
    INVALID_INPUT("\n[ERROR] 유효하지 않은 입력입니다. 다시 시도해 주세요."),
    ASSIGNED_ONCE_EACH("\n[ERROR] 비상 근무자는 평일 순번, 휴일 순번에 각각 1회 편성되어야 합니다. 다시 시도해주세요."),
    INVALID_NUM_OF_WORKERS("\n[ERROR] 근무자는 최소 5명 이상, 최대 35명 이하여야합니다. 다시 시도해주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}