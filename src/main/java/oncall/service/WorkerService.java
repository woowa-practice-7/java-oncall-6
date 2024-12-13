package oncall.service;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import oncall.exception.DuplicatedAssignmentException;
import oncall.factory.WorkerFactory;
import oncall.factory.WorkersFactory;
import oncall.factory.WorkersOnDaysFactory;
import oncall.factory.WorkersOnHolidaysFactory;
import oncall.model.Worker;
import oncall.model.WorkerOnDays;
import oncall.model.WorkerOnHoliDays;
import oncall.model.Workers;

public class WorkerService {
    public Workers createWorkers(List<String> order) {
        Set<Worker> workers = new HashSet<>();
        for (String name : order) {
            Worker worker = WorkerFactory.createWorker(name);
            workers.add(worker);
        }

        return WorkersFactory.createWorkers(workers);
    }

    public WorkerOnDays createWorkerOnDays(Workers workers, List<String> orderOnDay) {
        Deque<Worker> workerOnDays = new ArrayDeque<>();
        for (String name : orderOnDay) {
            Worker worker = workers.findByName(name);
            workerOnDays.add(worker);
        }
        return WorkersOnDaysFactory.createWorkersOnDays(workerOnDays);
    }

    public WorkerOnHoliDays createWorkerOnHoliays(Workers workers, List<String> orderOnHoliday) {
        Deque<Worker> workerOnHolidays = new ArrayDeque<>();
        for (String name : orderOnHoliday) {
            Worker worker = workers.findByName(name);
            workerOnHolidays.add(worker);
        }
        return WorkersOnHolidaysFactory.createWorkerOnHoliDays(workerOnHolidays);
    }

    public void compareOrders(List<String> orderOnDay, List<String> orderOnHoliday) {
        if (orderOnDay.size() != orderOnHoliday.size()) {
            throw new DuplicatedAssignmentException();
        }
        List<String> orderOnDayCopy = new ArrayList<>(orderOnDay);

        List<String> orderOnHolidayCopy = new ArrayList<>(orderOnHoliday);

        Collections.sort(orderOnDayCopy);
        Collections.sort(orderOnHolidayCopy);
        for (int i = 0; i < orderOnDay.size(); i++) {
            if (!orderOnDayCopy.get(i).equals(orderOnHolidayCopy.get(i))) {
                throw new DuplicatedAssignmentException();
            }
        }
    }
}
