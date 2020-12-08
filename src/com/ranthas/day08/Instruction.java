package com.ranthas.day08;

public class Instruction {

    private String code;
    private long value;
    private boolean executed;

    public Instruction(String code, long value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public boolean isExecuted() {
        return executed;
    }

    public void setExecuted(boolean executed) {
        this.executed = executed;
    }

    public boolean isAccumulate() {
        return code.equals("acc");
    }

    public boolean isJump() {
        return code.equals("jmp");
    }

    public boolean isNop() {
        return code.equals("nop");
    }
}
