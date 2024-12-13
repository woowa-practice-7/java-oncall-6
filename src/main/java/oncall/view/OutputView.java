package oncall.view;

import oncall.model.WorkingDays;

public class OutputView {
    public static void showResult(WorkingDays workingDays) {
        workingDays.printOrder();
    }

    public static void printError(String Message) {
        System.out.println(Message);
    }
}
