package com.ranthas.day02.part01;

import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

public class DayTwo {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day02/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        StringLineToPassword stringLineConverter = new StringLineToPasswordImpl();

        final long count =
                fileService
                .readAllLines(DATA_INPUT_FILE)
                .stream()
                .map(stringLineConverter::convert)
                .filter(Password::isValid)
                .count();

        System.out.println("There are " + count + " valid passwords");
    }
}
