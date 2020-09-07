import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConvertArabToRoman {

    public static String getListDigits(int roman) {
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int number = roman;
        int thousands = 0;
        int hundreds = 0;
        int tens = 0;
        if (number >= 1000) {
            thousands = number / 1000;
            sb.append(getRomeNum(1000, thousands));
            list.add(thousands * 1000);
            number = (number % 1000);
        }
        if (number >= 100) {
            hundreds = number / 100;
            if (hundreds < 9 && hundreds > 5) {
                sb.append(getRomeNum(100, 5));
                sb.append(getRomeNum(100, hundreds - 5));
            } else {
                sb.append(getRomeNum(100, hundreds));
            }
            number = (number % 100);
        }
        if (number >= 10) {
            tens = number / 10;
            if (tens < 9 && tens > 5) {
                sb.append(getRomeNum(10, 5));
                sb.append(getRomeNum(10, tens - 5));
            } else {
                sb.append(getRomeNum(10, tens));
            }
            number = (number % 10);
        }

        if (number < 9 && number > 5) {
            sb.append(getRomeNum(5, 1));
            sb.append(getRomeNum(1, number - 5));
        } else if (number < 4 && number > 1) {
            sb.append(getRomeNum(1, number));
        }
        sb.append(getRomeNum(number, 1));
        return sb.toString();
    }

    private static String getRomeNum(int num, int numberOfUnits) {
        StringBuilder sb = new StringBuilder();

        for (RomanNumeral e : RomanNumeral.getReverseSortedValues()) {
            if (e.getValue() == (num * numberOfUnits)) {
                sb.append(e);
                return sb.toString();
            }
            if (e.getValue() == num && numberOfUnits > 0) {
                for (int i = 0; i < numberOfUnits; i++) {
                    sb.append(e);
                }
                return sb.toString();
            }
            if (e.getValue() == num && numberOfUnits == 0) {
                sb.append(e);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(getListDigits(4));
    }
}
