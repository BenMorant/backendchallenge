package com.glady.benmorant.service;

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

    public void calculateBalance() {
        for (Item item : user.getItems()) {
            if (item.getExpirationDate().isAfter(LocalDate.now(clock))) {
                user.setBalance(user.getBalance() + item.getAmount());
            }
        }
    }

}
