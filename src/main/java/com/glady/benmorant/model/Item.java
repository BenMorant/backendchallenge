package com.glady.benmorant.model;

import java.time.LocalDate;

public abstract class Item {

    private final long amount;

    private final LocalDate distributionDate;

    private final ItemType itemType;

    protected LocalDate expirationDate;

    public Item(long amount, LocalDate distributionDate, ItemType itemType) {
        this.amount = amount;
        this.distributionDate = distributionDate;
        this.itemType = itemType;
    }

    public long getAmount() {
        return amount;
    }

    public LocalDate getDistributionDate() {
        return distributionDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public ItemType getItemType() {
        return itemType;
    }

}
