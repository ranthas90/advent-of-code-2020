package com.ranthas.day05;

public class BinaryNumber {

    private final String row;
    private final String column;

    public BinaryNumber(String number) {
        this.row = number.substring(0, 7);
        this.column = number.substring(7);
    }

    public long getUniqueID() {
        return getDecimalValue(row) * 8L + getDecimalValue(column);
    }

    private long getDecimalValue(String number) {

        long decimalValue = 0L;

        for (int i = 0; i < number.length(); i++) {

            long exponent = number.length() - 1 - i;
            long pow = (long) Math.pow(2, exponent);

            decimalValue = decimalValue + (getBinaryValue(number.charAt(i)) * pow);
        }

        return decimalValue;
    }

    private long getBinaryValue(char character) {

        if (character == 'F' || character == 'L') {
            return 0L;
        }

        if (character == 'B' || character == 'R') {
            return 1L;
        }

        throw new IllegalArgumentException("Character cannot be different from F or B => " + character);
    }
}
