package oncall.model;

import java.util.Deque;

public class WorkerOnDays {
    private final Deque<Worker> workers;

    public WorkerOnDays(Deque<Worker> workers) {
        this.workers = workers;
    }

    public Worker getFirstWorker() {
        return workers.getFirst();
    }

    public Worker assignFirstWorker() {
        Worker worker = workers.removeFirst();
        workers.add(worker);
        return worker;
    }

    public void switchWorkers() {
        Worker worker1 = workers.remove();
        Worker worker2 = workers.remove();
        workers.addFirst(worker1);
        workers.addFirst(worker2);
    }
}
