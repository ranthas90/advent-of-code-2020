package com.ranthas.day09.part02;

import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.Arrays;
import java.util.Collections;

public class DayNine {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day09/data-input.aoc";
    private static final long WRONG_NUMBER = 85848519L;

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        long[] numbers =
                fileService
                        .readAllLines(DATA_INPUT_FILE)
                        .stream()
                        .mapToLong(Long::parseLong)
                        .toArray();

        for (int i = 0; i < numbers.length; i++) {

            int firstIndex = i;
            int secondIndex = 0;

            long exploitSum = numbers[i];
            int nextCounter = 1;

            while (exploitSum < WRONG_NUMBER) {

                secondIndex = i + nextCounter;
                exploitSum = exploitSum + numbers[secondIndex];
                nextCounter++;
            }

            if (exploitSum == WRONG_NUMBER) {

                long[] exploitNumbers = new long[secondIndex - firstIndex + 1];
                System.arraycopy(numbers, firstIndex, exploitNumbers, 0, exploitNumbers.length);

                long solution = getSolution(exploitNumbers);

                System.out.println("From [" + i + "] to [" + (i+nextCounter-1) + "]");
                System.out.println("The solution is " + solution);
                System.exit(0);
            }
        }
    }

    private static long getSolution(long[] exploitNumbers) {

        Arrays.sort(exploitNumbers);

        return exploitNumbers[0] + exploitNumbers[exploitNumbers.length - 1];
    }
}
