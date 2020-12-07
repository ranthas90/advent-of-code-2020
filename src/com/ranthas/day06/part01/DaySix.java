package com.ranthas.day06.part01;

import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class DaySix {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day06/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        List<String> lines = fileService.readAllLines(DATA_INPUT_FILE);
        List<String> responses = new ArrayList<>();
        List<DeclarationForm> declarationForms = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {

            String line = lines.get(i);

            if (!"".equals(line)) {
                responses.add(line);
            } else {
                declarationForms.add(new DeclarationForm(new ArrayList<>(responses)));
                responses.clear();
            }

            if (i == lines.size() - 1) {
                declarationForms.add(new DeclarationForm(new ArrayList<>(responses)));
                responses.clear();
            }
        }

        final int sum =
                declarationForms.stream().mapToInt(DeclarationForm::countAffirmativeResponses).sum();

        System.out.println("The solution is " + sum);
    }

}
