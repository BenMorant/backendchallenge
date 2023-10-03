package com.glady.benmorant.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private final String name;
    private final List<Item> items = new ArrayList<>();
    private long balance;


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

    public List<Item> getItems() {
        return items;
    }


    public void addItem(Item item) {
        items.add(item);
    }
}
