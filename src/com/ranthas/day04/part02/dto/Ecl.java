package com.ranthas.day04.part02.dto;

import java.util.List;

public class Ecl implements Validable {

    private String value;
    private List<String> validValues;

    public Ecl(String value) {
        this.value = value;
        this.validValues = List.of("amb", "blu", "brn", "gry", "grn", "hzl", "oth");
    }

    @Override
    public boolean isValid() {
        return validValues.contains(value);
    }
}
