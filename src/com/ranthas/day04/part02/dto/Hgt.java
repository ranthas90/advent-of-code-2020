package com.ranthas.day04.part02.dto;

public class Hgt implements Validable {

    private int value;
    private String scale;

    public Hgt(String value) {

        if (value.endsWith("cm")) {
            this.scale = "cm";
            this.value = Integer.parseInt(value.replace("cm", ""));
        }

        if (value.endsWith("in")) {
            this.scale = "in";
            this.value = Integer.parseInt(value.replace("in", ""));
        }
    }

    @Override
    public boolean isValid() {

        if ("cm".equals(scale)) {
            return value >= 150 && value <= 193;
        }

        if ("in".equals(scale)) {
            return value >= 59 && value <= 76;
        }

        return false;
    }
}
