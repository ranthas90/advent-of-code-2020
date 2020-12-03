package com.ranthas.day03.part02;

import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.List;

public class DayThree {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day03/data-input.aoc";

    private static List<String> lines;
    private static int lineLength;

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();

        lines = fileService.readAllLines(DATA_INPUT_FILE);
        lineLength = lines.get(0).length();

        long result = (long) firstSlope() * secondSlope() * thirdSlope() * fourthSlope() * fifthSlope();
        System.out.println("The solution is " + result);

    }

    private static int firstSlope() {

        int currentIndex = 1;
        int numberOfTrees = 0;

        for (int i = 0; i < lines.size() - 1; i++) {

            char nextLocation = lines.get(i + 1).charAt(currentIndex);

            if (nextLocation == '#') {
                numberOfTrees++;
            }

            if (currentIndex + 1 > lineLength - 1) {
                currentIndex = currentIndex + 1 - lineLength;
            } else {
                currentIndex = currentIndex + 1;
            }
        }

        return numberOfTrees;
    }

    private static int secondSlope() {

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

        return numberOfTrees;
    }

    private static int thirdSlope() {

        int currentIndex = 5;
        int numberOfTrees = 0;

        for (int i = 0; i < lines.size() - 1; i++) {

            char nextLocation = lines.get(i + 1).charAt(currentIndex);

            if (nextLocation == '#') {
                numberOfTrees++;
            }

            if (currentIndex + 5 > lineLength - 1) {
                currentIndex = currentIndex + 5 - lineLength;
            } else {
                currentIndex = currentIndex + 5;
            }
        }

        return numberOfTrees;
    }

    private static int fourthSlope() {

        int currentIndex = 7;
        int numberOfTrees = 0;

        for (int i = 0; i < lines.size() - 1; i++) {

            char nextLocation = lines.get(i + 1).charAt(currentIndex);

            if (nextLocation == '#') {
                numberOfTrees++;
            }

            if (currentIndex + 7 > lineLength - 1) {
                currentIndex = currentIndex + 7 - lineLength;
            } else {
                currentIndex = currentIndex + 7;
            }
        }

        return numberOfTrees;
    }

    private static int fifthSlope() {

        int currentIndex = 1;
        int numberOfTrees = 0;

        for (int i = 0; i < lines.size() - 2; i = i + 2) {

            char nextLocation = lines.get(i + 2).charAt(currentIndex);

            if (nextLocation == '#') {
                numberOfTrees++;
            }

            if (currentIndex + 1 > lineLength - 1) {
                currentIndex = currentIndex + 1 - lineLength;
            } else {
                currentIndex = currentIndex + 1;
            }
        }

        return numberOfTrees;
    }
}
