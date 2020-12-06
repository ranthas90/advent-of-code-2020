package com.ranthas.day06.part02;

import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DaySix {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day06/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        List<String> lines = fileService.readAllLines(DATA_INPUT_FILE);
        List<DeclarationForm> declarationForms = new ArrayList<>();
        List<GroupDeclarationForm> groupForms = new ArrayList<>();

        for (int i = 0; i < lines.size(); i++) {

            String line = lines.get(i);

            if (!"".equals(line)) {
                declarationForms.add(new DeclarationForm(line));
            } else {
                groupForms.add(new GroupDeclarationForm(new ArrayList<>(declarationForms)));
                declarationForms.clear();
            }

            if (i == lines.size() - 1) {
                groupForms.add(new GroupDeclarationForm(new ArrayList<>(declarationForms)));
                declarationForms.clear();
            }
        }

        final long sum =
                groupForms.stream().mapToLong(GroupDeclarationForm::countEveryoneAffirmativeResponses).sum();

        System.out.println("The solution is " + sum);
    }
}
