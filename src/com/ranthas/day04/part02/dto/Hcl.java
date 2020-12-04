package com.ranthas.day04.part02.dto;

public class Hcl implements Validable {

    private String value;

    public Hcl(String value) {
        this.value = value;
    }

    @Override
    public boolean isValid() {
        return value.matches("#[0-9a-f]{6}");
    }
}
