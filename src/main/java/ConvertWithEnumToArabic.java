import java.util.*;
import java.util.stream.Collectors;

public class ConvertWithEnumToArabic {

    public static int romanToArabic(String input) {
        String romanNumber = input.toUpperCase();
        int result = 0;

        List<RomanNumeral> listConstants = RomanNumeral.getReverseSortedValues();

        int i = 0;

        while ((romanNumber.length() > 0) && (i < listConstants.size())) {
            RomanNumeral symbol = listConstants.get(i);
            if (romanNumber.startsWith(symbol.name())) {
                result += symbol.getValue();
                romanNumber = romanNumber.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumber.length() > 0) {
            throw new IllegalArgumentException(input + " it is not Roman Number");
        }
        return result;
    }

    public static void main(String[] args) {
        int a = romanToArabic("C");
        System.out.println(a);
    }
}
