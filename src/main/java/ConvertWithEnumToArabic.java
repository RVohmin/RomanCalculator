import java.util.*;
import java.util.stream.Collectors;

public class ConvertWithEnumToArabic {
    private final Map<String, Integer> map = new HashMap<>();

    {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
    }

    enum RomanNumeral {
        I(1), IV(4), V(5), IX(9), X(10),
        XL(40), L(50), XC(90), C(100),
        CD(400), D(500), CM(900), M(1000);

        private final int value;

        RomanNumeral(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static List<RomanNumeral> getReverseSortedValues() {
            return Arrays.stream(values())
                    .sorted(Comparator.comparing((RomanNumeral e) -> e.value).reversed())
                    .collect(Collectors.toList());
        }
    }

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
        int a = romanToArabic("MCMXCIV");
        System.out.println(a);
    }
}
