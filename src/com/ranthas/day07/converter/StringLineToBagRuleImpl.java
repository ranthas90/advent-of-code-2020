package com.ranthas.day07.converter;

import com.ranthas.day07.dto.BagQuantity;
import com.ranthas.day07.dto.BagRule;
import com.ranthas.day07.dto.BagType;

import java.util.ArrayList;
import java.util.List;

public class StringLineToBagRuleImpl implements StringLineToBagRule {

    @Override
    public BagRule convert(String line) {

        BagRule bag = new BagRule();
        String[] split = line.split(" contain ");

        String bagTypeColor = split[0].replace("bags", "").trim();
        bag.setBag(new BagType(bagTypeColor));

        if (split[1].equals("no other bags.")) {
            bag.setContains(null);

        } else {
            String[] bagTypes = split[1].split(",");
            List<BagQuantity> quantities = new ArrayList<>();

            for (String bagType : bagTypes) {

                String[] bagTypeSplit = bagType.trim().split(" ");
                int quantity = Integer.parseInt(bagTypeSplit[0]);
                String bagSplit = bagTypeSplit[1] + " " + bagTypeSplit[2];

                quantities.add(new BagQuantity(quantity, new BagType(bagSplit)));
            }

            bag.setContains(quantities);
        }

        return bag;
    }
}
