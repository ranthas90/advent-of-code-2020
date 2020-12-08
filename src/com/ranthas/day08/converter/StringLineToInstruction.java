package com.ranthas.day08.converter;

import com.ranthas.day08.Instruction;

public interface StringLineToInstruction {

    Instruction convert(String line);
}
