package oncall.config;

import oncall.service.WorkerAssignmentService;
import oncall.service.WorkerService;
import oncall.service.WorkingDayService;

public class AppConfig {
    public WorkingDayService workingDayService() {
        return new WorkingDayService();
    }

    public WorkerService workerService() {
        return new WorkerService();
    }

    public WorkerAssignmentService workerAssignmentService() {
        return new WorkerAssignmentService();
    }
}