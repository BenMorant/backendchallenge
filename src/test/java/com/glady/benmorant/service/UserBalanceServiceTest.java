package com.glady.benmorant.service;

import com.glady.benmorant.exception.BeyondExpirationException;
import com.glady.benmorant.model.Gift;
import com.glady.benmorant.model.Item;
import com.glady.benmorant.model.Meal;
import com.glady.benmorant.model.User;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserBalanceServiceTest {

    private UserBalanceService userBalanceService;

    @Test
    void should_add_amount_to_users_balance_nominal() {
        // GIVEN
        User john = new User("John");
        Item item = new Gift(100L, LocalDate.now());
        long expectedBalance = 100L;
        userBalanceService = new UserBalanceService(john);
        // WHEN
        userBalanceService.calculateUserBalance(item);
        // THEN
        assertEquals(expectedBalance, john.getBalance());
    }


    @Test
    void should_throw_BeyondExpirationException_when_item_amount_bigger_than_company_balance() {
        // GIVEN
        LocalDate distributionDate = LocalDate.now().minusYears(2);
        User john = new User("John");
        Item item = new Meal(100L, distributionDate);
        long expectedBalance = 0L;
        userBalanceService = new UserBalanceService(john);
        String expectedMessage = "This deposit is beyond expiration. The Meal amount ($100) hasn't been counted in John's balance.";
        // WHEN, THEN
        Exception exception = assertThrows(BeyondExpirationException.class, () -> userBalanceService.calculateUserBalance(item));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        assertEquals(expectedBalance, john.getBalance());

    }

}