package com.ranthas.day10.part02;

import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

public class DayTen {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day10/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        long[] adapters =
                fileService
                        .readAllLines(DATA_INPUT_FILE)
                        .stream()
                        .mapToLong(Long::parseLong)
                        .sorted()
                        .toArray();

        int validCount = 0;
        int groupOfOne = 0;
        int groupOfTwo = 0;
        int groupOfThree = 0;

        for (int i = 0; i < adapters.length - 1; i++) {

            boolean isValid;
            if (i == 0) {
                 isValid = isValidForRemoving(0L, adapters[i + 1]);
            } else {
                isValid = isValidForRemoving(adapters[i - 1], adapters[i + 1]);
            }

            if (validCount == 3) {
                validCount = 0;
                groupOfThree++;
            }

            if (isValid) {
                validCount++;
            } else {
                if (validCount == 2) {
                    groupOfTwo++;
                }
                if (validCount == 1) {
                    groupOfOne++;
                }
                validCount = 0;
            }
        }

        if (validCount == 3) {
            groupOfThree++;
        }

        if (validCount == 2) {
            groupOfTwo++;
        }

        if (validCount == 1) {
            groupOfOne++;
        }

        long solution = (long) (Math.pow(7, groupOfThree) * Math.pow(4, groupOfTwo) * Math.pow(2, groupOfOne));

        System.out.println("The solution is " + solution);
    }

    private static boolean isValidForRemoving(long firstTerm, long secondTerm) {
        return (secondTerm - firstTerm) < 3L;
    }
}
