package oncall.controller;

import java.util.List;
import oncall.config.Container;
import oncall.model.WorkerOnDays;
import oncall.model.WorkerOnHoliDays;
import oncall.model.Workers;
import oncall.model.WorkingDays;
import oncall.service.WorkerAssignmentService;
import oncall.service.WorkerService;
import oncall.service.WorkingDayService;
import oncall.util.Reader;
import oncall.view.InputView;
import oncall.view.OutputView;

public class WorkController {
    private final WorkerService workerService;
    private final WorkingDayService workingDayService;
    private final WorkerAssignmentService workerAssignmentService;

    public WorkController(Container container) {
        this.workerService = container.getWorkerService();
        this.workingDayService = container.getWorkingDayService();
        this.workerAssignmentService = container.getWorkerAssignmentService();
    }

    public void run() {
        // 사용자에게 월, 시작요일 입력받기
        DayInfo dayInfo = getValidDayInfo();

        // 평일 근무명단 입력받기
        WorkerDayData workerDayData = getValidWorkersOnDay();

        // 휴일 근무명단 입력받기
        WorkerOnHoliDays workerOnHoliDays = getValidWorkersOnHoliday(workerDayData.orderOnDay, workerDayData.workers);

        // 월, 시작요일에 맞게 WorkingDay들 생성
        WorkingDays workingDays = workingDayService.createWorkingDays(dayInfo.month, dayInfo.dayOfWeek);

        // 근무명단에 맞춰 차례대로 배정
        workerAssignmentService.assignWorkers(workingDays, workerDayData.workerOnDays, workerOnHoliDays);

        // 결과 출력
        OutputView.showResult(workingDays);
    }

    private DayInfo getValidDayInfo() {
        while (true) {
            try {
                String input = InputView.getDay();
                Integer month = Reader.getMonth(input);
                String dayOfWeek = Reader.getDayOfWeek(input);
                return new DayInfo(month, dayOfWeek);
            } catch (Exception e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private WorkerDayData getValidWorkersOnDay() {
        while (true) {
            try {
                String input = InputView.getWorkOrderOnDay();
                List<String> orderOnDay = Reader.getOrder(input);
                Workers workers = workerService.createWorkers(orderOnDay);
                WorkerOnDays workerOnDays = workerService.createWorkerOnDays(workers, orderOnDay);
                return new WorkerDayData(orderOnDay, workers, workerOnDays);
            } catch (Exception e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private WorkerOnHoliDays getValidWorkersOnHoliday(List<String> orderOnDay, Workers workers) {
        while (true) {
            try {
                String input = InputView.getWorkOrderOnHoliday();
                List<String> orderOnHoliday = Reader.getOrder(input);
                workerService.compareOrders(orderOnDay, orderOnHoliday);
                return workerService.createWorkerOnHoliays(workers, orderOnHoliday);
            } catch (Exception e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    // Helper classes to encapsulate data
    private static class DayInfo {
        final Integer month;
        final String dayOfWeek;

        DayInfo(Integer month, String dayOfWeek) {
            this.month = month;
            this.dayOfWeek = dayOfWeek;
        }
    }

    private static class WorkerDayData {
        final List<String> orderOnDay;
        final Workers workers;
        final WorkerOnDays workerOnDays;

        WorkerDayData(List<String> orderOnDay, Workers workers, WorkerOnDays workerOnDays) {
            this.orderOnDay = orderOnDay;
            this.workers = workers;
            this.workerOnDays = workerOnDays;
        }
    }
}
