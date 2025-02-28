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

        assertEquals("   product 101\n \"Hot Tea\"\n     price 1.99\n", p1);
    }

    //finish on letter f p.40
}
