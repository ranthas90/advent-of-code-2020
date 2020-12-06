package com.ranthas.day06.part01;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DeclarationForm {

    private List<String> responses;

    public DeclarationForm(List<String> responses) {
        this.responses = responses;
    }

    public int countAffirmativeResponses() {

        String flat = String.join("", responses);
        return Arrays
                .stream(flat.split(""))
                .collect(Collectors.groupingBy(character -> character, Collectors.counting()))
                .entrySet()
                .size();
    }
}
