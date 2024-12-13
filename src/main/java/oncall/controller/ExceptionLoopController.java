package oncall.controller;

import java.util.function.Supplier;

public abstract class ExceptionLoopController {
    protected <T> T repeatUntilValid(Supplier<T> function) {
        while (true) {
            try {
                return function.get();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}