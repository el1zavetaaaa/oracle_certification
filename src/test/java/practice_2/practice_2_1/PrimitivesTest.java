package practice_2.practice_2_1;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
}
