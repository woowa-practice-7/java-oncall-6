package oncall.factory;

import java.util.Set;
import oncall.model.Worker;
import oncall.model.Workers;

public class WorkersFactory {
    public static Workers createWorkers(Set<Worker> workers) {
        return new Workers(workers);
    }
}
