package com.glady.benmorant.model;

public enum ItemType {

    GIFT("Gift"), MEAL("Meal");

    private final String name;

    ItemType(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
}
