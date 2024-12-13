package oncall.model;

import oncall.exception.NameLengthException;

public class Worker {
    private String name;

    public Worker(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new NameLengthException();
        }
    }

    public String getName() {
        return name;
    }
}
