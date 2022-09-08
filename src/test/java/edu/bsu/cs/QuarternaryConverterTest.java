package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuarternaryConverterTest {
    @Test
    public void testConvertDecimalToQuarternary(){
        QuarternaryConverter calculator = new QuarternaryConverter();
        int input = 73;
        Assertions.assertEquals("1021", calculator.convertDecimalToQuarternary(input));
    }

    @Test
    public void testConvertQuarternaryToDecimal(){
        QuarternaryConverter calculator = new QuarternaryConverter();
        String input = "1021";
        Assertions.assertEquals(73, calculator.convertQuarternatyToDecimal(input));
    }
}
