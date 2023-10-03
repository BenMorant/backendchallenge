package com.glady.benmorant.model;

public class Company {

    final private String name;

    private Long balance;

    public Company(String name, Long balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
