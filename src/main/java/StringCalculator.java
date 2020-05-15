import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static String add(String s) {
        if (s.isEmpty()) {
            return "0";
        }
        if (!s.contains(",")&&!s.contains("\n")&&!s.contains("//")) {
            return s;
        }

        List<String> numbers;
        if(s.contains("//")){
            char separator = s.charAt(2);
            s = s.substring(3);
            numbers = separateString(s,separator);
        }else{
            numbers = separateString(s);
        }
        int result = 0;
        result = sum_strings(numbers, result);
        return String.valueOf(result);

    }

    private static List<String> separateString(String s) {
        return Arrays.asList(s.split(",|\\n"));
    }
    private static List<String> separateString(String s,char separator) {
        String regex = ",|\\n|".concat(String.valueOf(separator));
        return Arrays.asList(s.split(regex));
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
