package oncall.factory;

import oncall.model.Worker;

public class WorkerFactory {
    public static Worker createWorker(String name) {
        return new Worker(name);
    }
}
