package com.ranthas.day07.dto;

import java.util.List;

public class BagRule {

    private BagType bag;
    private List<BagQuantity> contains;

    public BagRule() {
    }

    public BagType getBag() {
        return bag;
    }

    public void setBag(BagType bag) {
        this.bag = bag;
    }

    public List<BagQuantity> getContains() {
        return contains;
    }

    public void setContains(List<BagQuantity> contains) {
        this.contains = contains;
    }

    public boolean canHoldBagType(String bagType) {

        BagType bagTypeHold = new BagType(bagType);

        if (contains == null) {
            return false;
        }

        for (BagQuantity quantity : contains) {

            BagType bagTypeContains = quantity.getBag();

            if (bagTypeContains.equals(bagTypeHold)) {
                return true;
            }
        }

        return false;
    }
}
