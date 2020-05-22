import java.util.ArrayList;
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
        boolean textContainsSeparator = text.contains("//");
        if (textContainsSeparator) {
            List<String> separators = getSeparators(text);
            text = getTextAfterSeparators(text);
            splitText = separateString(text, separators);
        } else {
            splitText = separateString(text);
        }
        return String.valueOf(sumNumbers(splitText));
    }

    private static boolean isSingleNumber(String text) {
        return !text.contains(",") && !text.contains("\n") && !text.contains("//");
    }

    private static List<String> getSeparators(String text) {
        text=text.replaceAll("[0-9]+.*[0-9]+","");
        String[] matchCustomSeparators = text.split("\\n");
        List<String>separators=new ArrayList<>();
        for(String matchCustomSeparator:matchCustomSeparators){
            matchCustomSeparator=matchCustomSeparator.replace("//","");
            separators.add(matchCustomSeparator);
        }
        return separators;
    }

    private static String getTextAfterSeparators(String text) {
        String[] numbers= text.split("//.*\\n");
        String numberText = "";
        for(String number:numbers){
            numberText=numberText.concat(number);
        }
        return numberText;
    }

    private static List<String> separateString(String text) {
        return Arrays.asList(text.split("[,\\n]"));
    }

    private static List<String> separateString(String text, List<String> separators) {
        String regex = "[,\\n]";
        for (String separator:
             separators) {
        regex=regex.concat("|".concat(separator));
        }
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
