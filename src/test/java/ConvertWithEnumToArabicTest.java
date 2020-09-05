import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConvertWithEnumToArabicTest {
    @Test
    public void convertToArab() {
        ConvertWithEnumToArabic convertWithEnumToArabic = new ConvertWithEnumToArabic();
        assertEquals( 1, ConvertWithEnumToArabic.romanToArabic("I"));
        assertEquals( 2, ConvertWithEnumToArabic.romanToArabic("II"));
        assertEquals( 4, ConvertWithEnumToArabic.romanToArabic("IV"));
        assertEquals( 9, ConvertWithEnumToArabic.romanToArabic("IX"));
        assertEquals( 40, ConvertWithEnumToArabic.romanToArabic("XL"));
        assertEquals( 90, ConvertWithEnumToArabic.romanToArabic("XC"));
        assertEquals( 101, ConvertWithEnumToArabic.romanToArabic("CI"));
        assertEquals( 105, ConvertWithEnumToArabic.romanToArabic("CV"));
        assertEquals( 150, ConvertWithEnumToArabic.romanToArabic("CL"));
        assertEquals( 200, ConvertWithEnumToArabic.romanToArabic("CC"));
        assertEquals( 400, ConvertWithEnumToArabic.romanToArabic("CD"));
        assertEquals( 12, ConvertWithEnumToArabic.romanToArabic("XII"));
        assertEquals( 16, ConvertWithEnumToArabic.romanToArabic("XVI"));
        assertEquals( 14, ConvertWithEnumToArabic.romanToArabic("XIV"));
        assertEquals( 19, ConvertWithEnumToArabic.romanToArabic("XIX"));
        assertEquals( 30, ConvertWithEnumToArabic.romanToArabic("XXX"));
        assertEquals( 45, ConvertWithEnumToArabic.romanToArabic("XLV"));
        assertEquals( 54, ConvertWithEnumToArabic.romanToArabic("LIV"));
        assertEquals( 70, ConvertWithEnumToArabic.romanToArabic("LXX"));
        StringBuilder sb = new StringBuilder("CCCLXXXIX");
    }

}