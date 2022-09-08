package edu.bsu.cs;

public class QuarternaryConverter {

    public static void main(String[] args) {
        QuarternaryConverter calculator = new QuarternaryConverter();
        calculator.convertDecimalToQuarternary(73);
    }

    public String convertDecimalToQuarternary(int decimal){
        int result;
        StringBuilder quarternary = new StringBuilder();
        while (decimal != 0){
            result = decimal % 4;
            decimal = (decimal - result) / 4;
            quarternary.insert(0, result);
        }
        return quarternary.toString();
    }

    public int convertQuarternatyToDecimal(String quarternary){
        int multiplier = 0;
        int total = 0;
        int factor;
        StringBuilder quarternaryString;
        quarternaryString = new StringBuilder(quarternary);
        while (quarternaryString.length() != 0){
            char temp = quarternaryString.charAt(quarternaryString.length() - 1);
            int num = Character.getNumericValue(temp);
            factor = (int) Math.pow(4,multiplier);
            num = num * factor;
            multiplier += 1;
            quarternaryString.deleteCharAt(quarternaryString.length() - 1);
            total += num;
        }
        return total;
    }
}
