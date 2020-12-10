package com.ranthas.day10.part01;

import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

public class DayTen {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day10/data-input.aoc";

    private static long oneJolt = 0L;
    private static long threeJolt = 0L;

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        long[] adapters =
                fileService
                        .readAllLines(DATA_INPUT_FILE)
                        .stream()
                        .mapToLong(Long::parseLong)
                        .sorted()
                        .toArray();

        for (int i = 0; i < adapters.length; i++) {
            if (i == 0) {
                checkJolts(0L, adapters[i]);
            } else {
                checkJolts(adapters[i - 1], adapters[i]);
            }
        }

        threeJolt++;

        System.out.println("The solution is " + (oneJolt * threeJolt));
    }

    private static void checkJolts(long lastAdapter, long currentAdapter) {

        long difference = currentAdapter - lastAdapter;

        if (difference == 1L) {
            oneJolt++;
        }

        if (difference == 3L) {
            threeJolt++;
        }
    }
}
