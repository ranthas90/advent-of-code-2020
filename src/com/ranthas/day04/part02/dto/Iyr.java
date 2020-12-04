package com.ranthas.day04.part02.dto;

public class Iyr implements Validable {

    private int value;

    public Iyr(String value) {
        this.value = Integer.parseInt(value);
    }

    @Override
    public boolean isValid() {
        return value >= 2010 && value <= 2020;
    }
}
