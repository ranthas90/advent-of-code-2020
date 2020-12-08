package com.ranthas.day08.part01;

import com.ranthas.day08.Instruction;
import com.ranthas.day08.converter.StringLineToInstruction;
import com.ranthas.day08.converter.StringLineToInstructionImpl;
import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public class DayEight {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day08/data-input.aoc";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        StringLineToInstruction converter = new StringLineToInstructionImpl();

        long accumulate = 0L;
        List<Instruction> instructions =
                fileService
                        .readAllLines(DATA_INPUT_FILE)
                        .stream()
                        .map(converter::convert)
                        .collect(Collectors.toList());

        for (int i = 0; i < instructions.size(); i++) {

            Instruction instruction = instructions.get(i);

            if (instruction.isExecuted()) {
                System.out.println("The solution is " + accumulate);
                System.exit(0);
            }

            instructions.get(i).setExecuted(true);

            if (instruction.isAccumulate()) {
                accumulate = accumulate + instruction.getValue();
            }

            if (instruction.isJump()) {
                i = (int) (i + instruction.getValue() - 1);
            }

        }
    }
}
