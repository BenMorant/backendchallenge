package com.glady.benmorant.service;

import com.glady.benmorant.model.Item;
import com.glady.benmorant.model.User;

public class UserBalanceService {

    private final User user;

    public UserBalanceService(User user) {
        this.user = user;
    }

    public long calculateUserBalance(Item item) {

        return user.getBalance() + item.getAmount();

    }
}
