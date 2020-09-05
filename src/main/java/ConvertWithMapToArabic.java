import java.util.*;
import java.util.stream.Collectors;

public class ConvertWithMapToArabic {
    private final Map<String, Integer> map = new HashMap<String, Integer>();

    {
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC",90);
        map.put("C", 100);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
    }

    private final LinkedHashSet<String> values =
            map.keySet().stream()
                    .sorted(Comparator.comparing(map::get).reversed())
                    .collect(Collectors.toCollection(LinkedHashSet::new));
    private final List<String> romes =
            map.keySet().stream()
                    .sorted(Comparator.comparing(map::get).reversed())
                    .collect(Collectors.toList());

    public int romanToArabic(String input) {
        String romanNumber = input.toUpperCase();
        int result = 0;
        int i = 0;

        while ((romanNumber.length() > 0) && (i < romes.size())) {
            String symbol = romes.get(i);
            if (romanNumber.startsWith(symbol)) {
                result += map.get(symbol);
                romanNumber = romanNumber.substring(symbol.length());
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
        ConvertWithMapToArabic mapToArabic = new ConvertWithMapToArabic();
        System.out.println(mapToArabic.romes);
        System.out.println(mapToArabic.values);
        int a = mapToArabic.romanToArabic("CCCLXXXIX");
        System.out.println(a);
    }
}
