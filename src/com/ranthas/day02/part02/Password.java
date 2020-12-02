package com.ranthas.day02.part02;

public class Password {

    private int firstIndex;
    private int secondIndex;
    private char character;
    private String password;

    public Password(int firstIndex, int secondIndex, char character, String password) {
        this.firstIndex = firstIndex;
        this.secondIndex = secondIndex;
        this.character = character;
        this.password = password;
    }

    public int getFirstIndex() {
        return firstIndex;
    }

    public void setFirstIndex(int firstIndex) {
        this.firstIndex = firstIndex;
    }

    public int getSecondIndex() {
        return secondIndex;
    }

    public void setSecondIndex(int secondIndex) {
        this.secondIndex = secondIndex;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {

        char firstMatch = password.charAt(firstIndex);
        char secondMatch = password.charAt(secondIndex);

        return (firstMatch == character) ^ (secondMatch == character);
    }
}
