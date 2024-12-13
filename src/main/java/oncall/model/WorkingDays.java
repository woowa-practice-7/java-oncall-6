package oncall.model;

import java.util.List;

public class WorkingDays {
    List<WorkingDay> workingDays;

    public WorkingDays(List<WorkingDay> workingDays) {
        this.workingDays = workingDays;
    }

    public void assignWorkers(WorkerOnDays workerOnDays, WorkerOnHoliDays workerOnHoliDays) {
        Worker yesterdayWorker = null;
        for (WorkingDay workingDay : workingDays) {
            if (workingDay.isHoliday()) {
                Worker worker = workerOnHoliDays.getFirstWorker();
                if (yesterdayWorker != null && yesterdayWorker.equals(worker)) {
                    workerOnHoliDays.switchWorkers();
                }
                worker = workerOnHoliDays.assignFirstWorker();
                workingDay.assignWorker(worker);
                yesterdayWorker = worker;
                continue;
            }
            Worker worker = workerOnDays.getFirstWorker();
            if (yesterdayWorker != null && yesterdayWorker.equals(worker)) {
                workerOnDays.switchWorkers();
            }
            worker = workerOnDays.assignFirstWorker();
            workingDay.assignWorker(worker);
            yesterdayWorker = worker;
        }
    }

    public void printOrder() {
        for (WorkingDay workingDay : workingDays) {
            System.out.println(workingDay);
        }
    }
}
