package com.ranthas.day04.part02.dto;

public class Eyr implements Validable {

    private int value;

    public Eyr(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public boolean isValid() {
        return value >= 2020 && value <= 2030;
    }
}
