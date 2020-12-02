package com.ranthas.day02.part01;

public class StringLineToPasswordImpl implements StringLineToPassword {

    @Override
    public Password convert(String line) {

        final String[] split = line.split(" ");
        final String[] occurs = split[0].split("-");

        final long minOccurs = Long.parseLong(occurs[0]);
        final long maxOccurs = Long.parseLong(occurs[1]);
        final String character = split[1].replace(":", "");
        final String password = split[2];
        final Policy policy = new Policy(minOccurs, maxOccurs, character);

        return new Password(policy, password);
    }
}
