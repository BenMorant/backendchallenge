package com.glady.benmorant.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String name;

    private long balance;

    private List<Item> userItems = new ArrayList<>();


    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public List<Item> getUserItems() {
        return userItems;
    }

    public void setUserItems(List<Item> userItems) {
        this.userItems = userItems;
    }

    public void addItem(Item item) {
        userItems.add(item);
    }
}
