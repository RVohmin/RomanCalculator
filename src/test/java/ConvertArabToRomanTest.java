import org.junit.Test;

import static org.junit.Assert.*;

public class ConvertArabToRomanTest {

    @Test
    public void convertToArab() {
        for (int i = 1; i < 4000; i++) {
            String roman = ConvertArabToRoman.getListDigits(i);
            int arabic = ConvertWithEnumToArabic.romanToArabic(roman);
            System.out.printf("%d = %s\n", arabic, roman);
            assertEquals(arabic, i);
        }
    }
    @Test
    public void convertWithMapToArab() {
        ConvertWithMapToArabic map = new ConvertWithMapToArabic();
        for (int i = 1; i < 4000; i++) {
            String roman = ConvertArabToRoman.getListDigits(i);
            int arabic = map.romanToArabic(roman);
            System.out.printf("%d = %s\n", arabic, roman);
            assertEquals(arabic, i);
        }
    }
}