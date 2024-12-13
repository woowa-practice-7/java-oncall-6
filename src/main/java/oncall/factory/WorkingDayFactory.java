package oncall.factory;

import oncall.model.DayOfWeek;
import oncall.model.WorkingDay;

public class WorkingDayFactory {
    public static WorkingDay createWorkingDay(Integer month, Integer day, DayOfWeek dayOfWeek) {
        return new WorkingDay(month, day, dayOfWeek);
    }
}
