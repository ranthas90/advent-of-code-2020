package com.ranthas.day05.part02;

import com.ranthas.day05.BinaryNumber;
import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public class DayFive {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day05/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        final List<Long> collect =
                fileService
                        .readAllLines(DATA_INPUT_FILE)
                        .stream()
                        .map(line -> new BinaryNumber(line).getUniqueID())
                        .sorted()
                        .collect(Collectors.toList());

        for (int i = 1; i < collect.size() - 1; i++) {

            long currentNumber = collect.get(i);
            long previousNumber = collect.get(i - 1);

            if (previousNumber + 1 == currentNumber - 1) {
                System.out.println("The solution is " + (currentNumber - 1));
                System.exit(0);
            }
        }

        System.err.println("No solution found!!");
    }
}
