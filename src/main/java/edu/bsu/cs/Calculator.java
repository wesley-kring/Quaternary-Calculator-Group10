package edu.bsu.cs;

public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        calculator.convertDecimalToQuarternary(73);
    }
    public String convertDecimalToQuarternary(int baseTen){
        int result;
        StringBuilder quarternary = new StringBuilder();
        while (baseTen != 0){
            result = baseTen % 4;
            baseTen = (baseTen - result) / 4;
            quarternary.insert(0, result);
        }
        return quarternary.toString();
    }
}
