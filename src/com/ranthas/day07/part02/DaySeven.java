package com.ranthas.day07.part02;

import com.ranthas.day07.converter.StringLineToBagRule;
import com.ranthas.day07.converter.StringLineToBagRuleImpl;
import com.ranthas.day07.dto.BagQuantity;
import com.ranthas.day07.dto.BagRule;
import com.ranthas.day07.dto.BagType;
import com.ranthas.util.FileService;
import com.ranthas.util.FileServiceImpl;

import java.util.stream.Collectors;

public class DaySeven {

    private static final String DATA_INPUT_FILE = "src/com/ranthas/day07/data-input.aoc";

    public static void main(String[] args) {

        BagRule shinyGold = getBagFromList(new BagType("shiny gold"));
        final long deep = calculateBagDeep(shinyGold);

        System.out.println("The solution is " + deep);
    }

    private static BagRule getBagFromList(BagType bagType) {

        FileService fileService = new FileServiceImpl();
        StringLineToBagRule converter = new StringLineToBagRuleImpl();

        return fileService
                .readAllLines(DATA_INPUT_FILE)
                .stream()
                .map(converter::convert)
                .filter(bagRule -> bagRule.getBag().equals(bagType))
                .collect(Collectors.toList())
                .get(0);
    }

    private static long calculateBagDeep(BagRule rule) {

        long total = 0L;

        if (rule.getContains() == null) {
            return 0L;
        }

        for (BagQuantity quantity : rule.getContains()) {

            int q = quantity.getQuantity();
            BagRule bagRule = getBagFromList(quantity.getBag());

            total = total + q + (q * calculateBagDeep(bagRule));
        }

        return total;
    }
}
