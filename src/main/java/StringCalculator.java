import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static int add(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        if (!s.contains(",")) {
            return parseInt(s);
        }
        
        List<String> numbers = Arrays.asList(s.split(","));
        int result = 0;
        result = sum_strings(numbers, result);
        return result;
    }

    private static int sum_strings(List<String> numbers, int result) {
        if (numbers.size() > 0) {
            result += parseInt(numbers.get(0));
            List<String> rest = numbers.subList(1, numbers.size());
            return sum_strings(rest, result);
        }
        return result;
    }

}
