package com.ranthas.day02.part01;

public class Policy {

    private long minOccurs;
    private long maxOccurs;
    private String character;

    public Policy(long minOccurs, long maxOccurs, String character) {
        this.minOccurs = minOccurs;
        this.maxOccurs = maxOccurs;
        this.character = character;
    }

    public long getMinOccurs() {
        return minOccurs;
    }

    public void setMinOccurs(long minOccurs) {
        this.minOccurs = minOccurs;
    }

    public long getMaxOccurs() {
        return maxOccurs;
    }

    public void setMaxOccurs(long maxOccurs) {
        this.maxOccurs = maxOccurs;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public boolean isInRange(long number) {
        return number >= minOccurs && number <= maxOccurs;
    }
}
