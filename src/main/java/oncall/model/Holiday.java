package oncall.model;

public enum Holiday {
    NEW_YEAR(1, 1),
    SAM_IL_JEOL(3, 1),
    CHILDREN_DAY(5, 5),
    MEMORIAL_DAY(6, 6),
    LIBERATION_DAY(8, 15),
    HANGUL_DAY(10, 9),
    CHRISTMAS(12, 25);

    private final Integer month;
    private final Integer day;

    Holiday(Integer month, Integer day) {
        this.month = month;
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public Integer getDay() {
        return day;
    }
}
