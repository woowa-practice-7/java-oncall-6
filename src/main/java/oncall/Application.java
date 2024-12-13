package oncall;

import oncall.config.Container;
import oncall.controller.WorkController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Container container = new Container();
        WorkController workController = new WorkController(container);
        workController.run();
    }
}
