package com.ranthas.day04.part02.converter;

import com.ranthas.day04.part02.dto.*;

import java.util.List;
import java.util.stream.Collectors;

public class LinesListToPassportImpl implements LinesListToPassport {

    @Override
    public Passport convert(List<String> lines) {

        Passport passport = new Passport();
        String join = lines.stream().collect(Collectors.joining(" "));
        String[] split = join.split(" ");

        for (String splittedItem : split) {

            int index = splittedItem.indexOf(":");
            String item = splittedItem.substring(index + 1);

            if (splittedItem.contains("byr:")) {
                passport.setByr(new Byr(item));
            }

            if (splittedItem.contains("iyr:")) {
                passport.setIyr(new Iyr(item));
            }

            if (splittedItem.contains("eyr:")) {
                passport.setEyr(new Eyr(item));
            }

            if (splittedItem.contains("hgt:")) {
                passport.setHgt(new Hgt(item));
            }

            if (splittedItem.contains("hcl:")) {
                passport.setHcl(new Hcl(item));
            }

            if (splittedItem.contains("ecl:")) {
                passport.setEcl(new Ecl(item));
            }

            if (splittedItem.contains("pid:")) {
                passport.setPid(new Pid(item));
            }
        }

        return passport;
    }
}
