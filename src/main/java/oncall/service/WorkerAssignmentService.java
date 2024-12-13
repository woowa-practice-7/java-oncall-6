package oncall.service;

import oncall.model.WorkerOnDays;
import oncall.model.WorkerOnHoliDays;
import oncall.model.WorkingDays;

public class WorkerAssignmentService {
    public void assignWorkers(WorkingDays workingDays, WorkerOnDays workerOnDays,
                              WorkerOnHoliDays workerOnHoliDays) {
        workingDays.assignWorkers(workerOnDays, workerOnHoliDays);
    }
}
