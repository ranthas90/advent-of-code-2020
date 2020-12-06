package com.ranthas.day05.part01;

import com.ranthas.day05.BinaryNumber;
import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class DayFive {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day05/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        BinaryNumber binaryNumber =
                fileService
                        .readAllLines(DATA_INPUT_FILE)
                        .stream()
                        .map(BinaryNumber::new)
                        .max(Comparator.comparing(BinaryNumber::getUniqueID))
                        .orElseThrow(NoSuchElementException::new);

        System.out.println("The solution is " + binaryNumber.getUniqueID());
    }
}
