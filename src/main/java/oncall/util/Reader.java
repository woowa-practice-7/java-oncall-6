package oncall.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import oncall.exception.GeneralException;

public class Reader {
    public static Integer getMonth(String dayInput) {
        List<String> inputs = getStringsUsingDelimiter(dayInput, ",");
        try {
            Integer month = Integer.parseInt(inputs.get(0));
            if (month < 1 || month > 12) {
                throw new GeneralException();
            }
            return month;
        } catch (Exception e) {
            throw new GeneralException();
        }
    }

    public static String getDayOfWeek(String dayInput) {
        List<String> inputs = getStringsUsingDelimiter(dayInput, ",");
        List<String> days = new ArrayList<>();
        days.add("월");
        days.add("화");
        days.add("수");
        days.add("목");
        days.add("금");
        days.add("토");
        days.add("일");
        if (!days.contains(inputs.get(1))) {
            throw new GeneralException();
        }
        return inputs.get(1);
    }

    public static List<String> getOrder(String orderInput) {
        List<String> order = getStringsUsingDelimiter(orderInput, ",");
        return order;
    }

    private static List<String> getStringsUsingDelimiter(String input, String delimiter) {
        List<String> inputs = Arrays.stream(input.split(delimiter))
                .map(String::trim)
                .collect(Collectors.toList());
        return inputs;
    }


}
