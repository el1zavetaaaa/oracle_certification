package practice_2.practice_2_2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IfElseAndSwitchConstructsTest {


    @ParameterizedTest
    @CsvSource({"h,H", "{,{", "H,h"})
    public void simpleIfElse(char input, char result) {

        if (input >= 'a' && input <= 'z') {
            input -= 32;
        } else if (input >= 'A' && input <= 'Z') {
            input += 32;
        }

        assertEquals(input, result);
    }

    @ParameterizedTest
    @CsvSource({"h,H", "H,h"})
    public void simpleTernaryOperator(char input, char result) {
        char output = input >= 'a' && input <= 'z' ? (char) (input - 32) : (char) (input + 32);
        assertEquals(output, result);
    }

    @ParameterizedTest
    @CsvSource({"1,10.5f", "3, 11.57625f", "4, 12.0"})
    public void switchStatementFallThroughBehaviour(int period, float result) {
        float amount = 10;
        float rate = 0.05f;

        // the absence of break statements inside individual case statements
        // means that once an algorithm jumps to a specific case,
        // it just continues to subsequent cases
        // until it reaches the end of the switch construct
        switch (period) {
            case 4:
                amount += amount * 0.2F;
                break;
            case 3:
                amount += amount * rate;
            case 2:
                amount += amount * rate;
            case 1:
                amount += amount * rate;
        }

        assertEquals(result, amount);
    }


    @ParameterizedTest
    @CsvSource({"1,0.1f, 550.0f, 5950.0f", "5, 0.08f, 2200.0f, 7600.00f", "10, 0.07F, 3850.0f, 9200.0f", "11, 0.06F, 3630.0f, 8930.0f"})
    public void switchExpression(int period, float expectedRate, float expectedSimpleInterest, float expectedDiscountedAmount) {
        float amount = 5500;
        float rate = 0;

        rate = switch (period) {
            case 1, 2, 3 -> 0.1F;
            case 4, 5, 6 -> 0.08F;
            case 7, 8, 9, 10 -> 0.07F;
            default -> 0.06F;
        };

        assertEquals(rate, expectedRate);

        float simpleInterest = amount * period * rate;

        assertEquals(simpleInterest, expectedSimpleInterest);

        //switch expression with yield keyword
        //yield keyword can be skipped for simple -> notation expressions,
        // but it is required for the : notation expressions

        //discounted amount to repay
        amount +=
                switch (period) {
                    case 1, 2, 3, 4, 5:
                        yield simpleInterest - 100.0F;
                    case 6, 7, 8, 9, 10:
                        yield simpleInterest - 150.0F;
                    default:
                        yield simpleInterest - 200.0F;
                };

        assertEquals(amount, expectedDiscountedAmount);
    }

}
