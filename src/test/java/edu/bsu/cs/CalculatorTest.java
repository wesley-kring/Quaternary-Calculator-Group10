package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testConvertDecimalToQuarternary(){
        Calculator calculator = new Calculator();
        int input = 73;
        Assertions.assertEquals("1021", calculator.convertDecimalToQuarternary(input));
    }
}
