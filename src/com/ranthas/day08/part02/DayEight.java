package com.ranthas.day08.part02;

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

        long accumulate = 0L;
        List<Instruction> instructions = buildInstructions();

        for (int i = 0; i < instructions.size(); i++) {

            Instruction instruction = instructions.get(i);

            if (instruction.isExecuted()) {
                System.out.println("The solution is " + accumulate);
                System.exit(0);
            }

            boolean checkResult = false;

            if (instruction.isJump()) {
                checkResult = checkProgram(i, "nop");
                i = (int) (i + instruction.getValue() - 1);

            } else if (instruction.isNop()) {
                checkResult = checkProgram(i, "jmp");

            } else {
                accumulate = accumulate + instruction.getValue();
            }

            instructions.get(i).setExecuted(true);

            if (checkResult) {
                System.exit(0);
            }
        }
    }

    private static boolean checkProgram(int index, String code) {

        long accumulate = 0L;
        List<Instruction> copy = buildInstructions();
        copy.get(index).setCode(code);

        for (int i = 0; i < copy.size(); i++) {

            Instruction instruction = copy.get(i);

            if (i == copy.size() - 1) {
                System.out.println("End of program reach; the solution is " + accumulate);
                return true;
            }

            if (instruction.isExecuted()) {
                return false;
            }

            copy.get(i).setExecuted(true);

            if (instruction.isAccumulate()) {
                accumulate = accumulate + instruction.getValue();
            }

            if (instruction.isJump()) {
                i = (int) (i + instruction.getValue() - 1);
            }
        }

        return false;
    }

    private static List<Instruction> buildInstructions() {

        FileService fileService = new FileServiceImpl();
        StringLineToInstruction converter = new StringLineToInstructionImpl();

        return fileService
                .readAllLines(DATA_INPUT_FILE)
                .stream()
                .map(converter::convert)
                .collect(Collectors.toList());
    }
}
