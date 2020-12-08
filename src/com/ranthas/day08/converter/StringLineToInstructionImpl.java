package com.ranthas.day08.converter;

import com.ranthas.day08.Instruction;

public class StringLineToInstructionImpl implements StringLineToInstruction {

    @Override
    public Instruction convert(String line) {

        String[] split = line.split(" ");
        String code = split[0].trim();
        long value = Long.parseLong(split[1].trim());

        return new Instruction(code, value);
    }
}
