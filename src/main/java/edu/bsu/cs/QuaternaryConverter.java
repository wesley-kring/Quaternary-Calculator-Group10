package edu.bsu.cs;

public class QuaternaryConverter {

    public String convertDecimalToQuaternary(int decimal){
        int result;
        StringBuilder quaternary = new StringBuilder();
        while (decimal != 0){
            result = decimal % 4;
            decimal = (decimal - result) / 4;
            quaternary.insert(0, result);
        }
        return quaternary.toString();
    }

    public int convertQuaternaryToDecimal(String quaternary){
        int multiplier = 0;
        int total = 0;
        int factor;
        StringBuilder quaternaryString;
        quaternaryString = new StringBuilder(quaternary);
        while (quaternaryString.length() != 0){
            char temp = quaternaryString.charAt(quaternaryString.length() - 1);
            int num = Character.getNumericValue(temp);
            factor = (int) Math.pow(4,multiplier);
            num = num * factor;
            multiplier += 1;
            quaternaryString.deleteCharAt(quaternaryString.length() - 1);
            total += num;
        }
        return total;
    }
}
