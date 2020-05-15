import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.lang.Integer.parseInt;

public class StringCalculator {
    public static String add(String text) {
        if (text.isEmpty()) {
            return "0";
        }
        if (!text.contains(",") && !text.contains("\n") && !text.contains("//")) {
            return text;
        }

        List<String> splitText;
        if (text.contains("//")) {
            char separator = getSeparator(text);
            text = getTextAfterSeparator(text);
            splitText = separateString(text, separator);
        } else {
            splitText = separateString(text);
        }
        int result = 0;
        result = sum_strings(splitText, result);
        return String.valueOf(result);

    }

    private static String getTextAfterSeparator(String texto) {
        return texto.substring(3);
    }

    private static char getSeparator(String texto) {
        return texto.charAt(2);
    }

    private static List<String> separateString(String texto) {
        return Arrays.asList(texto.split(",|\\n"));
    }

    private static List<String> separateString(String texto, char separator) {
        String regex = ",|\\n|".concat(String.valueOf(separator));
        return Arrays.asList(texto.split(regex));
    }

    private static int sum_strings(List<String> splitText, int result) {
        if (splitText.size() > 0) {
            result += parseInt(splitText.get(0));
            List<String> rest = splitText.subList(1, splitText.size());
            return sum_strings(rest, result);
        }
        return result;
    }

}
