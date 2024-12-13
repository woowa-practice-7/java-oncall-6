package oncall.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Reader {
    public static Integer getMonth(String dayInput) {
        List<String> inputs = getStringsUsingDelimiter(dayInput, ",");
        return Integer.parseInt(inputs.get(0));
    }

    public static String getDay(String dayInput) {
        List<String> inputs = getStringsUsingDelimiter(dayInput, ",");
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
