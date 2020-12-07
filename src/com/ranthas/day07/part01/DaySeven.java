package com.ranthas.day07.part01;

import com.ranthas.day07.converter.StringLineToBagRule;
import com.ranthas.day07.converter.StringLineToBagRuleImpl;
import com.ranthas.day07.dto.BagRule;
import com.ranthas.day07.dto.BagType;
import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DaySeven {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day07/data-input.aoc";

    private static Set<BagRule> allBags;
    private static Set<BagRule> validBags = new HashSet<>();

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        StringLineToBagRule converter = new StringLineToBagRuleImpl();

        allBags =
                fileService
                        .readAllLines(DATA_INPUT_FILE)
                        .stream()
                        .map(converter::convert)
                        .collect(Collectors.toSet());

        check(new BagType("shiny gold"));

        System.out.println("The solution is " + validBags.size());
    }

    private static void check(BagType bagType) {
        for (BagRule rule : allBags) {
            if (rule.canHoldBagType(bagType.getColor())) {
                validBags.add(rule);
                check(rule.getBag());
            }
        }
    }
}
