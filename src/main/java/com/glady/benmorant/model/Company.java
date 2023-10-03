package com.glady.benmorant.model;

public class Company {

    final private String name;

    private long balance;

    public Company(String name, Long balance) {
        this.name = name;
        this.balance = balance;
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
}
