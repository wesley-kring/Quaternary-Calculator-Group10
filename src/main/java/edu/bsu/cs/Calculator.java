package edu.bsu.cs;

public class Calculator {
    public String cache;
    QuaternaryConverter converter = new QuaternaryConverter();

    public Calculator(String cache){
        this.cache = cache;
    }

    public void cacheNumber(String quaternary){
        cache = quaternary;
    }

    public String add(String quaternaryX){
        int decimalCache = converter.convertQuaternaryToDecimal(cache);
        int decimalX = converter.convertQuaternaryToDecimal(quaternaryX);
        cache = converter.convertDecimalToQuaternary(decimalCache + decimalX);
        return cache;
    }
    public String subtract(String quaternaryX){
        int decimalCache = converter.convertQuaternaryToDecimal(cache);
        int decimalX = converter.convertQuaternaryToDecimal(quaternaryX);
        cache = converter.convertDecimalToQuaternary(decimalCache - decimalX);
        return cache;
    }
    public String multiply(String quaternaryX){
        int decimalCache = converter.convertQuaternaryToDecimal(cache);
        int decimalX = converter.convertQuaternaryToDecimal(quaternaryX);
        cache = converter.convertDecimalToQuaternary(decimalCache * decimalX);
        return cache;
    }
    public String divide(String quaternaryX){
        int decimalCache = converter.convertQuaternaryToDecimal(cache);
        int decimalX = converter.convertQuaternaryToDecimal(quaternaryX);
        cache = converter.convertDecimalToQuaternary(decimalCache / decimalX);
        return cache;
    }
    public String square(){
        int decimalCache = converter.convertQuaternaryToDecimal(cache);
        cache = converter.convertDecimalToQuaternary(decimalCache * decimalCache);
        return cache;
    }
    public String squareRoot(){
        int decimalCache = converter.convertQuaternaryToDecimal(cache);
        float answer = (float) Math.sqrt(decimalCache);
        cache = converter.convertDecimalToQuaternary((int) answer);
        return cache;
    }
}

