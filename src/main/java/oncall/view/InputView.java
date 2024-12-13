package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String DAY_INPUT_MESSAGE = "비상 근무를 배정할 월과 시작 요일을 입력하세요> ";
    private static final String WORK_ORDER_ON_DAY_MESSAGE = "평일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";
    private static final String WORK_ORDER_ON_HOLIDAY_MESSAGE = "휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> ";


    public static String getDay() {
        System.out.print(DAY_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String getWorkOrderOnDay() {
        System.out.print(WORK_ORDER_ON_DAY_MESSAGE);
        return Console.readLine();
    }

    public static String getWorkOrderOnHoliday() {
        System.out.print(WORK_ORDER_ON_HOLIDAY_MESSAGE);
        return Console.readLine();
    }
}
