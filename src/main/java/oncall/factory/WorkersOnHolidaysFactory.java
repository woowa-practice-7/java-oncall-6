package oncall.factory;

import java.util.Deque;
import oncall.model.Worker;
import oncall.model.WorkerOnHoliDays;

public class WorkersOnHolidaysFactory {
    public static WorkerOnHoliDays createWorkerOnHoliDays(Deque<Worker> workers) {
        return new WorkerOnHoliDays(workers);
    }
}
