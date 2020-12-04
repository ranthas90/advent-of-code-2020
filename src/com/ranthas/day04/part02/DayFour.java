package com.ranthas.day04.part02;

import com.ranthas.day04.part02.converter.LinesListToPassport;
import com.ranthas.day04.part02.converter.LinesListToPassportImpl;
import com.ranthas.day04.part02.dto.Passport;
import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayFour {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day04/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        LinesListToPassport converter = new LinesListToPassportImpl();
        List<Passport> passports = new ArrayList<>();
        List<String> passportFields = new ArrayList<>();
        List<String> lines = fileService.readAllLines(DATA_INPUT_FILE);

        for (int i = 0; i < lines.size(); i++) {

            String line = lines.get(i);

            if (!"".equals(line)) {
                passportFields.add(String.join(" ", Arrays.asList(line.split(" "))));
            } else {
                passports.add(converter.convert(passportFields));
                passportFields.clear();
            }

            if (i == lines.size() - 1) {
                passports.add(converter.convert(passportFields));
                passportFields.clear();
            }
        }

        final long count =
                passports.stream().filter(Passport::isValid).count();

        System.out.println("The solution is: " + count);
    }
}
