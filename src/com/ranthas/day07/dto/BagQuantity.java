package com.ranthas.day07.dto;

public class BagQuantity {

    private int quantity;
    private BagType bag;

    public BagQuantity(int quantity, BagType bag) {
        this.quantity = quantity;
        this.bag = bag;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BagType getBag() {
        return bag;
    }

    public void setBag(BagType bag) {
        this.bag = bag;
    }
}
