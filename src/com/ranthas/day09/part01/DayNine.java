package com.ranthas.day09.part01;

import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.stream.Collectors;

public class DayNine {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day09/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        long[] numbers =
                fileService
                        .readAllLines(DATA_INPUT_FILE)
                        .stream()
                        .mapToLong(Long::parseLong)
                        .toArray();

        for (int i = 25; i < numbers.length; i++) {

            long currentNumber = numbers[i];
            long[] preamble = new long[25];

            System.arraycopy(numbers, (i-25), preamble, 0, 25);

            if (!checkXMAS(preamble, currentNumber)) {
                System.out.println("The solution is " + currentNumber);
                System.exit(0);
            }
        }
    }

    private static boolean checkXMAS(long[] preamble, long checksum) {

        for (int i = 0; i < preamble.length; i++) {
            for (int j = 0; j < preamble.length; j++) {

                if (i == j) {
                    continue;
                }

                long first = preamble[i];
                long second = preamble[j];

                if ((first + second) == checksum) {
                    return true;
                }
            }
        }

        return false;
    }
}
