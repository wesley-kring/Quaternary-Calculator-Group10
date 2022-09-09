package edu.bsu.cs;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
    @Test
    public void testAdd(){
        Calculator calculator = new Calculator("1022");
        Assertions.assertEquals("3023", calculator.add("2001"));
    }
    @Test
    public void testSubtract(){
        Calculator calculator = new Calculator("2001");
        Assertions.assertEquals("333", calculator.subtract("1002"));
    }
    @Test
    public void testMultiply(){
        Calculator calculator = new Calculator("2001");
        Assertions.assertEquals("2011002", calculator.multiply("1002"));
    }
    @Test
    public void testDivide(){
        Calculator calculator = new Calculator("2001");
        Assertions.assertEquals("1", calculator.divide("1002"));
    }
}
