package com.ranthas.day01.part02;

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
                for (int k = 0; k < numbers.length; k++) {

                    if (i == j || i == k || j == k) {
                        continue;
                    }

                    int firstNumber = numbers[i];
                    int secondNumber = numbers[j];
                    int neededNumber = 2020 - firstNumber - secondNumber;

                    if (numbers[k] == neededNumber) {
                        System.out.println("The solution is " + firstNumber + "*" + secondNumber + "*" + neededNumber);
                        System.out.println(firstNumber * secondNumber * neededNumber);
                        System.exit(0);
                    }
                }
            }
        }
    }
}
