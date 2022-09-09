package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuarternaryConverterTest {
    @Test
    public void testConvertDecimalToQuarternary(){
        QuarternaryConverter converter = new QuarternaryConverter();
        int input = 73;
        Assertions.assertEquals("1021", converter.convertDecimalToQuarternary(input));
    }

    @Test
    public void testConvertQuarternaryToDecimal(){
        QuarternaryConverter converter = new QuarternaryConverter();
        String input = "1021";
        Assertions.assertEquals(73, converter.convertQuarternatyToDecimal(input));
    }
}

