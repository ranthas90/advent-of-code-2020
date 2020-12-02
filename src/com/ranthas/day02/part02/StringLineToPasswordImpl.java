package com.ranthas.day02.part02;

public class StringLineToPasswordImpl implements StringLineToPassword {

    @Override
    public Password convert(String line) {

        final String[] split = line.split(" ");
        final String[] occurs = split[0].split("-");

        final int firstIndex = Integer.parseInt(occurs[0]) - 1;
        final int secondIndex = Integer.parseInt(occurs[1]) - 1;
        final char character = split[1].replace(":", "").charAt(0);
        final String password = split[2];

        return new Password(firstIndex, secondIndex, character, password);
    }
}
