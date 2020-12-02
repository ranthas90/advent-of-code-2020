package com.ranthas.day02.part02;

public class Policy {

    private int matchIndex;
    private int unmatchIndex;
    private String character;

    public Policy(int matchIndex, int unmatchIndex, String character) {
        this.matchIndex = matchIndex;
        this.unmatchIndex = unmatchIndex;
        this.character = character;
    }

    public int getMatchIndex() {
        return matchIndex;
    }

    public void setMatchIndex(int matchIndex) {
        this.matchIndex = matchIndex;
    }

    public int getUnmatchIndex() {
        return unmatchIndex;
    }

    public void setUnmatchIndex(int unmatchIndex) {
        this.unmatchIndex = unmatchIndex;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }
}
