package oncall.factory;

import java.util.Deque;
import oncall.model.Worker;
import oncall.model.WorkerOnDays;

public class WorkersOnDaysFactory {
    public static WorkerOnDays createWorkersOnDays(Deque<Worker> workers) {
        return new WorkerOnDays(workers);
    }
}
