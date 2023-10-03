package com.glady.benmorant.service;

import com.glady.benmorant.exception.BeyondExpirationException;
import com.glady.benmorant.model.Item;
import com.glady.benmorant.model.User;

import java.time.Clock;
import java.time.LocalDate;

public class UserBalanceService {

    private final User user;

    private Clock clock;

    public UserBalanceService(User user) {
        this.user = user;
        this.clock = Clock.systemDefaultZone();
    }


    // for integration testing purposes
    public UserBalanceService(User user, Clock clock) {
        this.user = user;
        this.clock = clock;
    }

    public void calculateBalance(Item item) {
        if (item.getExpirationDate().isAfter(LocalDate.now(clock))) {
            user.setBalance(user.getBalance() + item.getAmount());
        } else {
            throw new BeyondExpirationException("This deposit is beyond expiration. The " + item.getItemType().getName() + " amount ($" + item.getAmount() + ") hasn't been counted in " + user.getName() + "'s balance.");
        }

    }
}
