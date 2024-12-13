package oncall.model;

import java.util.Objects;

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

    public void assignWorker(Worker worker) {
        this.worker = worker;
    }

    public Boolean isHoliday() {
        return isHoliday;
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

    @Override
    public String toString() {
        String yoil = dayOfWeek.getDayOfWeek();
        if (isHoliday && !Objects.equals(yoil, "토") && !Objects.equals(yoil, "일")) {
            yoil += "(휴일)";
        }
        return month + "월 " + day + "일 " + yoil + " " + worker.getName() + "\n";
    }
}
