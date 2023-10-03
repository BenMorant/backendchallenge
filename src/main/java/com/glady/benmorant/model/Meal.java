package com.glady.benmorant.model;

import java.time.LocalDate;
import java.time.Month;

public class Meal extends Item {
    public Meal(long amount, LocalDate distributionDate) {
        super(amount, distributionDate, ItemType.MEAL);
        this.expirationDate = getExpirationDateFrom(distributionDate);
    }

    private LocalDate getExpirationDateFrom(LocalDate distributionDate) {
        int expirationYear = distributionDate.getYear() + 1;
        LocalDate expirationDate = LocalDate.of(expirationYear, Month.FEBRUARY, 28);
        if (expirationDate.isLeapYear()) {
            expirationDate = LocalDate.of(expirationYear, Month.FEBRUARY, 29);
        }
        return expirationDate;
    }
}
