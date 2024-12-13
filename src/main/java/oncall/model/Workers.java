package oncall.model;

import java.util.Set;
import oncall.exception.DuplicatedAssignmentException;
import oncall.exception.NumberOfWorkersException;

public class Workers {
    private final Set<Worker> workers;

    public Workers(Set<Worker> workers) {
        checkDuplicatedName(workers);
        checkNumOfWorkers(workers);
        this.workers = workers;
    }

    public Worker findByName(String name) {
        for (Worker worker : workers) {
            if (name.equals(worker.getName())) {
                return worker;
            }
        }
        throw new RuntimeException("[ERROR] 존재하지 않는 근무자입니다.");
    }

    private void checkDuplicatedName(Set<Worker> workers) {
        for (Worker worker : workers) {
            String name = worker.getName();
            int count = 0;
            for (Worker worker1 : workers) {
                if (name.equals(worker1.getName())) {
                    count++;
                }
            }
            if (count > 1) {
                throw new DuplicatedAssignmentException();
            }
        }
    }

    private void checkNumOfWorkers(Set<Worker> workers) {
        if (workers.size() < 5 || workers.size() > 35) {
            throw new NumberOfWorkersException();
        }
    }
}
