package com.glady.benmorant.service;

import com.glady.benmorant.model.Gift;
import com.glady.benmorant.model.Item;
import com.glady.benmorant.model.ItemType;
import com.glady.benmorant.model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserBalanceServiceTest {

    private UserBalanceService userBalanceService;

    @Test
    void should_add_amount_to_users_balance_nominal() {
        // GIVEN
        User john = new User("John");
        Item item = new Gift(100L, LocalDate.now());
        long expectedBalance = 0L;
        userBalanceService = new UserBalanceService();
        // WHEN
        long actualBalance = userBalanceService.calculateUserBalance();
        // THEN
        assertEquals(expectedBalance, actualBalance);
    }

}