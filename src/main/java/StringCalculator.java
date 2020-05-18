import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static String add(String text) {
        if (text.isEmpty()) {
            return "0";
        }
        if (isSingleNumber(text)) {
            return text;
        }

        List<String> splitText;
        if (text.contains("//")) {
            String separator = getSeparator(text);
            text = getTextAfterSeparator(text);
            splitText = separateString(text, separator);
        } else {
            splitText = separateString(text);
        }
        return String.valueOf(sumNumbers(splitText));
    }

    private static boolean isSingleNumber(String text) {
        return !text.contains(",") && !text.contains("\n") && !text.contains("//");
    }

    private static String getSeparator(String text) {
        int indexDefaultNewLineSeparator = text.indexOf("\n");
        boolean hasDefaultNewLineSeparator = indexDefaultNewLineSeparator > 0;
        if (hasDefaultNewLineSeparator){
            return text.substring(2, indexDefaultNewLineSeparator);
        }else{
            int indexDefaultCommaSeparator = text.indexOf(",");
            return text.substring(2, indexDefaultCommaSeparator);
        }
    }

    private static String getTextAfterSeparator(String text) {
        int indexDefaultNewLineSeparator = text.indexOf("\n");
        boolean hasDefaultNewLineSeparator = indexDefaultNewLineSeparator > 0;
        if (hasDefaultNewLineSeparator){
            return text.substring(indexDefaultNewLineSeparator+1);
        }else{
            int indexDefaultCommaSeparator = text.indexOf(",");
            return text.substring(indexDefaultCommaSeparator+1);
        }
    }

    private static List<String> separateString(String text) {
        return Arrays.asList(text.split("[,\\n]"));
    }

    private static List<String> separateString(String text, String separator) {
        String regex = ",|\\n|".concat(String.valueOf(separator));
        return Arrays.asList(text.split(regex));
    }

    private static int sumNumbers(List<String> text) throws NegativesNotAllowedException {
        if (text.size() <= 0) {
            return 0;
        }
        int number = parseInt(text.get(0));
        List<String> rest = text.subList(1, text.size());
        if (number < 0) {
            throw new NegativesNotAllowedException(number);
        }
        if (number>1000){return sumNumbers(rest);}
        return number + sumNumbers(rest);
    }
}
