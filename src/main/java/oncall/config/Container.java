package oncall.config;

import oncall.service.WorkerAssignmentService;
import oncall.service.WorkerService;
import oncall.service.WorkingDayService;

public class Container {
    private final AppConfig config = new AppConfig();

    public WorkerService getWorkerService() {
        return config.workerService();
    }

    public WorkingDayService getWorkingDayService() {
        return config.workingDayService();
    }

    public WorkerAssignmentService getWorkerAssignmentService() {
        return config.workerAssignmentService();
    }
}

