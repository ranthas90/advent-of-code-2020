package com.ranthas.day04.part02.dto;

public class Pid implements Validable {

    private String value;

    public Pid(String value) {
        this.value = value;
    }

    @Override
    public boolean isValid() {
        return value.matches("[0-9]{9}");
    }
}
