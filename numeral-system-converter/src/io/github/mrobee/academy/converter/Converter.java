package io.github.mrobee.academy.converter;

import java.math.BigDecimal;

public class Converter {
    private final int source;
    private final String number;
    private final int destination;

    public Converter(int source, String number, int destination) {
        this.source = source;
        this.number = number;
        this.destination = destination;
    }

    public String convertNumber() {
        StringBuilder destNumber = new StringBuilder();
        String[] parts = number.split("\\.");

        destNumber.append(convertInteger(parts[0]));
        if (parts.length == 2) {
            destNumber.append(".");
            destNumber.append(convertFraction(parts[1]));
        }

        return destNumber.toString();
    }

    public String convertInteger(String number) {
        int intNumber;
        if (this.source == 1) {
            intNumber = baseOneToDec(number);
        } else {
            intNumber = Integer.parseInt(number, this.source);
        }

        String destNumber;
        if (this.destination == 1) {
            destNumber = decToBaseOne(intNumber);
        } else {
            destNumber = Integer.toString(intNumber, this.destination);
        }

        return destNumber;
    }

    public String convertFraction(String number) {
        double decimalFraction = fractionToDec(number);
        StringBuilder fraction = new StringBuilder();

        BigDecimal result = BigDecimal.valueOf(decimalFraction * this.destination);
        fraction.append(numToAlpha(result.intValue()));
        for (int i = 0; i < 4; i++) {
            result = BigDecimal.valueOf(result.remainder(BigDecimal.ONE).doubleValue() * this.destination);
            fraction.append(numToAlpha(result.intValue()));
        }

        return fraction.toString();
    }

    private double fractionToDec(String number) {
        double fraction = 0.0;
        for (int i = 0; i < number.length(); i++) {
            fraction += 1.0 * alphaToNum(number.charAt(i)) / Math.pow(this.source, i+1);
        }

        return fraction;
    }

    private int alphaToNum(char c) {
        String alpha = "0123456789abcdefghijklmnopqrstuvwxyz";
        return alpha.indexOf(c);
    }

    private char numToAlpha(long num) {
        String alpha = "0123456789abcdefghijklmnopqrstuvwxyz";
        return alpha.charAt((int) num);
    }

    private String decToBaseOne(int number) {
        return "1".repeat(Math.max(0, number));
    }

    private int baseOneToDec(String number) {
        return number.length();
    }
}
