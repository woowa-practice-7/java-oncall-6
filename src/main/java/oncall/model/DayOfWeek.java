package oncall.model;

public enum DayOfWeek {
    월("월"),
    화("화"),
    수("수"),
    목("목"),
    금("금"),
    토("토"),
    일("일");

    private final String dayOfWeek;

    DayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}
