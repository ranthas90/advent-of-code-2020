package com.ranthas.day04.part02.dto;

public class Byr implements Validable {

    private int value;

    public Byr(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public boolean isValid() {
        return value >= 1920 && value <= 2002;
    }
}
