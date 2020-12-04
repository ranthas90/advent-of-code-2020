package com.ranthas.day04.part01;

import java.util.List;
import java.util.stream.Collectors;

public class Passport {

    private List<String> fields;
    private String rawData;

    public Passport(List<String> fields) {
        this.fields = fields;
        this.rawData = fields.stream().collect(Collectors.joining());
    }

    public List<String> getFields() {
        return fields;
    }

    public void setFields(List<String> fields) {
        this.fields = fields;
    }

    public boolean isValid() {

        if (fields.size() < 7) {
            return false;
        }

        return rawData.contains("byr:") &&
                rawData.contains("iyr:") &&
                rawData.contains("eyr:") &&
                rawData.contains("hgt:") &&
                rawData.contains("hcl:") &&
                rawData.contains("ecl:") &&
                rawData.contains("pid:");
    }
}
