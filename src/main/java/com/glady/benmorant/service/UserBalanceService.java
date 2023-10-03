package com.glady.benmorant.service;

import com.glady.benmorant.exception.BeyondExpirationException;
import com.glady.benmorant.model.Item;
import com.glady.benmorant.model.User;

import java.time.LocalDate;

public class UserBalanceService {

    private final User user;

    public UserBalanceService(User user) {
        this.user = user;
    }

    public long calculateUserBalance(Item item) {
        if (item.getExpirationDate().isAfter(LocalDate.now())) {
            return user.getBalance() + item.getAmount();
        } else {
            throw new BeyondExpirationException("This deposit is beyond expiration. The " + item.getItemType().getName() + " amount ($" + item.getAmount() + ") hasn't been counted in " + user.getName() + "'s balance.");
        }

    }
}
