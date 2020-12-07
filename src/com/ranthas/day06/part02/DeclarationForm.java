package com.ranthas.day06.part02;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class DeclarationForm {

    private final String responses;

    public DeclarationForm(String responses) {
        this.responses = responses;
    }

    public Set<String> getAffirmativeResponses() {
        return Arrays
                .stream(responses.split(""))
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()))
                .keySet();
    }
}
