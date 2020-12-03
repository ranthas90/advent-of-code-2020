package com.ranthas.day03.part01;

import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.List;

public class DayThree {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day03/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        List<String> lines = fileService.readAllLines(DATA_INPUT_FILE);

        int lineLength = lines.get(0).length();
        int currentIndex = 3;
        int numberOfTrees = 0;

        for (int i = 0; i < lines.size() - 1; i++) {

            char nextLocation = lines.get(i + 1).charAt(currentIndex);

            if (nextLocation == '#') {
                numberOfTrees++;
            }

            if (currentIndex + 3 > lineLength - 1) {
                currentIndex = currentIndex + 3 - lineLength;
            } else {
                currentIndex = currentIndex + 3;
            }
        }

        System.out.println("The solution is " + numberOfTrees);
    }
}
