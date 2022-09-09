package edu.bsu.cs;

public class Calculator {
    public String currentNum;
    public String cache;
    QuarternaryConverter converter = new QuarternaryConverter();

    public Calculator(String cache){
        this.cache = cache;
    }

    public void cacheNumber(String quarternary){
        cache = quarternary;
    }

    public String add(String quaternaryX){
        int decimalCache = converter.convertQuarternatyToDecimal(cache);
        int decimalX = converter.convertQuarternatyToDecimal(quaternaryX);
        cache = converter.convertDecimalToQuarternary(decimalCache + decimalX);
        return cache;
    }
    public String subtract(String quaternaryX){
        int decimalCache = converter.convertQuarternatyToDecimal(cache);
        int decimalX = converter.convertQuarternatyToDecimal(quaternaryX);
        cache = converter.convertDecimalToQuarternary(decimalCache - decimalX);
        return cache;
    }
    public String multiply(String quaternaryX){
        int decimalCache = converter.convertQuarternatyToDecimal(cache);
        int decimalX = converter.convertQuarternatyToDecimal(quaternaryX);
        cache = converter.convertDecimalToQuarternary(decimalCache * decimalX);
        return cache;
    }
    public String divide(String quaternaryX){
        int decimalCache = converter.convertQuarternatyToDecimal(cache);
        int decimalX = converter.convertQuarternatyToDecimal(quaternaryX);
        cache = converter.convertDecimalToQuarternary(decimalCache / decimalX);
        return cache;
    }
    public String square(){
        int decimalCache = converter.convertQuarternatyToDecimal(cache);
        cache = converter.convertDecimalToQuarternary(decimalCache * decimalCache);
        return cache;
    }
    public String squareRoot(){
        int decimalCache = converter.convertQuarternatyToDecimal(cache);
        float answer = (float) Math.sqrt(decimalCache);
        cache = converter.convertDecimalToQuarternary((int) answer);
        return cache;
    }
}

