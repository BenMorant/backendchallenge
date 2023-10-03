package com.glady.benmorant.model;

import java.time.LocalDate;

public class Meal extends Item {
    public Meal(long amount, LocalDate distributionDate) {
        super(amount, distributionDate, ItemType.MEAL);
    }
}
