package oncall.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import oncall.factory.WorkingDayFactory;
import oncall.factory.WorkingDaysFactory;
import oncall.model.DayOfWeek;
import oncall.model.WorkingDay;
import oncall.model.WorkingDays;

public class WorkingDayService {
    public WorkingDays createWorkingDays(Integer month, String dayOfWeek) {
        Integer numOfDays = getNumOfDays(month);

        List<WorkingDay> workingDays = new ArrayList<>();

        List<DayOfWeek> dayOfWeeks = Arrays.stream(DayOfWeek.values()).toList();
        int startDay = dayOfWeeks.indexOf(DayOfWeek.valueOf(dayOfWeek));

        for (int i = 0; i < numOfDays; i++) {
            DayOfWeek day = dayOfWeeks.get(startDay % 7);
            WorkingDay workingDay = WorkingDayFactory.createWorkingDay(month, i + 1, day);
            workingDays.add(workingDay);
            startDay++;
        }

        return WorkingDaysFactory.createWorkingDays(workingDays);
    }

    private Integer getNumOfDays(Integer month) {
        if (month == 2) {
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        return 31;
    }
}
