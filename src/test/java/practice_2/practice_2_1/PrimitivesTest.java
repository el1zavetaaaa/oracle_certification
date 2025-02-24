package practice_2.practice_2_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PrimitivesTest {

    byte x = 2, y = 3, z = 5;

    @Test
    public void anyArithmeticOperationForTypesSmallerThanIntWillReturnInt() {
        assertTrue(Integer.valueOf(x + y) instanceof Integer);
    }

    @Test
    public void youNeedToCastForNeededTypeExplicitly() {
        z = (byte) (x + y);
        assertTrue(Byte.valueOf(z) instanceof Byte);
    }

    @Test
    public void theIntResultWillBeCastToFloatIfIAmCastingTheResultOfOperationNotParticipant() {
        float incorrect_float = (float) (x / y);
        assertTrue(incorrect_float == 0.0f);
    }

    @Test
    public void castingTheParticipantWillLeadToCorrectFloatResult() {
        float correct_float = (float) x / y;
        assertTrue(correct_float == 0.6666667f);
    }

    @Test
    public void roundingProblemsInJava() {
        float float_val = (float) x / y;
        double double_val = (double) x / y;

        assertTrue(double_val == 0.6666666666666666);
        assertTrue(float_val == 0.6666667f);

        double_val = float_val;

        assertTrue(double_val == 0.6666666865348816);

        float_val = Math.round(double_val * 1000) / 1000f;

        assertTrue(float_val == 0.667f);

    }

    @Test
    public void declareCharsUsingDifferentApproaches() {
        char a = 'a', a1 = '\141', a2 = '\u0061';

        assertTrue(a == a1 && a1 == a2);
    }

    @Test
    public void charAndIntCasting() {
        char a1 = '\141', a2 = '\u0061';
        int i = a1, i2 = 0141, i3 = 0x61;

        assertTrue(i == a1);
        assertTrue(i2 == a1);
        assertTrue(i3 == a2);

        char a3 = (char) i3;
        assertTrue(i3 == a3);
    }

    @Test
    public void arithmeticOperationsWithChars() {
        char someChar = 'k';

        boolean isEven = someChar % 2 == 0;
        assertFalse(isEven);
    }

    @Test
    public void calculateNextAndPreviousCharFromGiven() {
        char someChar = 'k';

        // if we are using first variant of calculation of the next char
        // => we will need to make an explicit type casting, because any arithmetic operation
        // will cast any values smaller than int to int
        char nextChar = (char) (someChar + 1);

        // however, if we are talking about the operators like ++ or --
        // in this case type casting is unnecessary, because those operators
        // modify the variable without changing its type
        ++someChar;


        assertTrue(someChar == 'l');
        assertTrue(nextChar == 'l');


        --someChar;
        assertTrue(someChar == 'k');
    }

    @Test
    public void symbolsIntValueConversion() {
        char upperA = 'A';
        char lowerA = 'a';

        int distance = lowerA - upperA;

        assertEquals(32, distance);

        // Equivalent upper and lowercase letters are 32 symbols apart
        // in the English alphabet, according to the ASCII character encoding

        char someChar = 'h';
        assertEquals(someChar - 32, 'H');
    }

}
