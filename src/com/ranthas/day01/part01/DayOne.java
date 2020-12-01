package com.ranthas.day01.part01;

import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

public class DayOne {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day01/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();


        final int[] numbers =
                fileService
                .readAllLines(DATA_INPUT_FILE)
                .stream()
                .mapToInt(Integer::parseInt)
                .toArray();


        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {

                if (i == j) {
                    continue;
                }

                int currentNumber = numbers[i];
                int neededNumber = 2020 - currentNumber;

                if (numbers[j] == neededNumber) {
                    System.out.println("The solution is " + currentNumber + "*" + neededNumber);
                    System.out.println(currentNumber * neededNumber);
                    System.exit(0);
                }
            }
        }
    }
}
