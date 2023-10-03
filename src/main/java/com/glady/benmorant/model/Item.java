package com.glady.benmorant.model;

import java.time.LocalDate;

public abstract class Item {

    private final long amount;

    private final LocalDate distributionDate;

    public Item(long amount, LocalDate distributionDate) {
        this.amount = amount;
        this.distributionDate = distributionDate;
    }

    public long getAmount() {
        return amount;
    }

    public LocalDate getDistributionDate() {
        return distributionDate;
    }
}
