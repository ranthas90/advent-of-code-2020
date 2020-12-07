package com.ranthas.day07.dto;

import java.util.Objects;

public class BagType {

    private String color;

    public BagType(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BagType bagType = (BagType) o;
        return color.equals(bagType.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color);
    }
}
