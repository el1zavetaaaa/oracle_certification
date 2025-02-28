package practice_3.practice_3_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringsTest {

    @Test
    public void internedStrings() {
        String teaTxt = "Tea";
        String b = "Tea";
        String c = new String("Tea");

        assertTrue(teaTxt == b);
        assertFalse(teaTxt == c);

        c.intern();
        // the string referenced by c variable has not been changed in any way, because all
        //string objects are immutable
        assertFalse(teaTxt == c);

        String d = c.intern();
        assertTrue(teaTxt == d);
    }

    @Test
    public void stringOperations() {
        String teaTxt = "Tea";
        String b = "Tea";

        String c = teaTxt + ' ' + b;
        assertEquals("Tea Tea", c);

        //find the position (index) of the second letter T within the c String
        //the first occurrence of letter 'T' is at the position 0,
        //so you need to start looking from the next position onwards
        assertEquals(4, c.indexOf('T', 1));

        //here the same result could be achieved using the method lastIndexOf()
        //however, here it is only possible, because there only 2 T letters in a string
        // so the second one is also coincidentally the last
        assertEquals(c.indexOf('T', 1), c.lastIndexOf('T'));

        //last character in the string
        assertEquals('a', c.charAt(c.length() - 1));

        assertEquals("TEA TEA", c.toUpperCase());

        // extract a portion from the String c, starting from the last occurrence of the letter 'T'
        //plus one more character
        // we need to add 2 to the upper bounder of this substring, because
        // upper bounder is not inclusive of the result
        assertEquals("Te", c.substring(c.lastIndexOf('T'), c.lastIndexOf('T') + 2));
    }

    @Test
    public void textBlocks() {
        String p1 = """
            product 101
          "Hot Tea"
              price 1.99
        """;

        // all the leading spaces there preserved, because the line with the least amount
        // of leading spaces is the last line, which contains only new line separation
        assertEquals("    product 101\n  \"Hot Tea\"\n      price 1.99\n", p1);

        //here, however, the line with the least amount of leading spaces
        // is the second line "Hot Tea", which have 2 leading spaces
        // that's why all other lines will be shifted to the left by 2 spaces
        // 1st line will have 2 leading spaces ad the last line - 4
        String p2 = """
            product 101
          "Hot Tea"
              price 1.99""";
        assertEquals("  product 101\n\"Hot Tea\"\n    price 1.99", p2);
    }

    @Test
    public void stringBuilderUsage(){
        StringBuilder txt = new StringBuilder("TEA TEA");
        assertEquals(7, txt.length());
        // for default stringbuilder constructor the capacity will be 16
        // for string argument constructor the capacity will be
        // string.length() + 16
        assertEquals(23, txt.capacity());

        //replace first TEA word with the phrase 'What is the price of?'
        txt.replace(0, 3, "What is the price of");
        assertEquals("What is the price of TEA", txt.toString());
        assertEquals(24, txt.length());

        // when appending data causes the current capacity to be exceeded,
        // the StringBuilder automatically increases its capacity.
        // The new capacity is calculated using the formula:
        //newCapacity = (oldCapacity * 2) + 2 => (23*2)+2
        assertEquals(48,txt.capacity());
    }

    @Test
    public void formatAndFormatted(){
        String p2 = "product: %d, %s, price: %2.2f";
        String result = "product: 101, Tea, price: 1,26";

        assertEquals(result, p2.formatted(101, "Tea", 1.255));
        assertEquals(result, String.format(p2, 101, "Tea", 1.255));
        // the same result will be with System.out.printf
        System.out.printf(p2, 101, "Tea", 1.255);
    }

}
