package com.glady.benmorant.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Item {

    private final long amount;

    private final LocalDate distributionDate;

    private final ItemType itemType;

    private List<User> destinationUsers = new ArrayList<>();


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

    public List<User> getDestinationUsers() {
        return destinationUsers;
    }

    public void setDestinationUsers(List<User> destinationUsers) {
        this.destinationUsers = destinationUsers;
    }

    public void addUsers(List<User> users) {
        destinationUsers.addAll(users);
    }


}
