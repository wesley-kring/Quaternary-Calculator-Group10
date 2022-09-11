package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuaternaryConverterTest {
    @Test
    public void testConvertDecimalToQuaternary(){
        QuaternaryConverter converter = new QuaternaryConverter();
        int input = 73;
        Assertions.assertEquals("1021", converter.convertDecimalToQuaternary(input));
    }

    @Test
    public void testConvertQuaternaryToDecimal(){
        QuaternaryConverter converter = new QuaternaryConverter();
        String input = "1021";
        Assertions.assertEquals(73, converter.convertQuaternaryToDecimal(input));
    }
}

