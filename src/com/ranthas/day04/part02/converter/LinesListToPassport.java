package com.ranthas.day04.part02.converter;

import com.ranthas.day04.part02.dto.Passport;

import java.util.List;

public interface LinesListToPassport {

    Passport convert(List<String> lines);
}
