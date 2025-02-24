package practice_2.practice_2_2;

import org.junit.jupiter.api.Test;
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
    @CsvSource({"1,10.5f", "3, 11.57625f"})
    public void switchWithFallThroughBehaviour(int period, float result){
        float amount = 10;
        float rate = 0.05f;

        // the absence of break statements inside individual case statements
        // means that once an algorithm jumps to a specific case,
        // it just continues to subsequent cases
        // until it reaches the end of the switch construct
        switch (period){
            case 3: amount += amount * rate;
            case 2: amount += amount * rate;
            case 1: amount += amount * rate;
        }

        assertEquals(result, amount);
    }

}
