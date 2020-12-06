package com.ranthas.day06.part02;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupDeclarationForm {

    private final List<DeclarationForm> declarationForms;

    public GroupDeclarationForm(List<DeclarationForm> declarationForms) {
        this.declarationForms = declarationForms;
    }

    public long countEveryoneAffirmativeResponses() {

        Iterator<Set<String>> allData =
                declarationForms.stream().map(DeclarationForm::getAffirmativeResponses).iterator();

        Set<String> result = new HashSet<>(allData.next());

        while (allData.hasNext()) {
            result.retainAll(allData.next());
        }

        return result.size();
    }
}
