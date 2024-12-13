package oncall.model;

public class WorkingDay {
    private Integer month;
    private Integer day;
    private DayOfWeek dayOfWeek;
    private Boolean isHoliday = false;
    private Worker worker = null;

    public WorkingDay(Integer month, Integer day, String dayOfWeek) {
        this.month = month;
        this.day = day;
        this.dayOfWeek = DayOfWeek.getDayofWeek(dayOfWeek);
        checkHoliday();
    }

    private void checkHoliday() {
        for (Holiday holiday : Holiday.values()) {
            if (holiday.getMonth().equals(month) && holiday.getDay().equals(day)) {
                isHoliday = true;
                break;
            }
        }
    }
}
