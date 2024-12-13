package oncall.factory;

import java.util.List;
import oncall.model.WorkingDay;
import oncall.model.WorkingDays;

public class WorkingDaysFactory {
    public static WorkingDays createWorkingDays(List<WorkingDay> workingDays) {
        return new WorkingDays(workingDays);
    }
}
