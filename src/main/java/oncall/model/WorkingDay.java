package oncall.model;

public class WorkingDay {
    private Integer month;
    private Integer day;
    private DayOfWeek dayOfWeek;
    private Boolean isHoliday = false;
    private Worker worker = null;

    public WorkingDay(Integer month, Integer day, DayOfWeek dayOfWeek) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = dayOfWeek;
        checkHoliday();
    }

    private void checkHoliday() {
        if (dayOfWeek.equals(DayOfWeek.토) || dayOfWeek.equals(DayOfWeek.일)) {
            isHoliday = true;
            return;
        }

        for (Holiday holiday : Holiday.values()) {
            if (holiday.getMonth().equals(month) && holiday.getDay().equals(day)) {
                isHoliday = true;
                return;
            }
        }
    }
}
