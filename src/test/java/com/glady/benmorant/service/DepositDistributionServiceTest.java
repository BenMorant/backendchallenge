package com.glady.benmorant.service;

import com.glady.benmorant.exception.NotEnoughBalanceException;
import com.glady.benmorant.model.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DepositDistributionServiceTest {

    private DepositDistributionService depositDistributionService;

    @Test
    void should_distribute_gift_with_positive_balance() {
        // GIVEN
        LocalDate distributionDate = LocalDate.now();
        User john = new User("John");
        Item item = new Gift(100L, distributionDate);
        item.addUsers(List.of(john));
        Company tesla = new Company("Tesla", 200L);
        depositDistributionService = new DepositDistributionService(tesla);
        // WHEN
        depositDistributionService.distribute(List.of(item));
        // THEN
        assertEquals(100L, tesla.getBalance());
        assertEquals(1, john.getUserItems().size());

    }

    @Test
    void should_throw_NotEnoughBalanceException_when_item_amount_bigger_than_company_balance() {
        // GIVEN
        LocalDate distributionDate = LocalDate.now();
        User john = new User("John");
        Item item = new Meal(100L, distributionDate);
        item.addUsers(List.of(john));
        Company tesla = new Company("Tesla", 50L);
        depositDistributionService = new DepositDistributionService(tesla);
        String expectedMessage = "Tesla has not enough balance for this distribution.";
        // WHEN, THEN
        Exception exception = assertThrows(NotEnoughBalanceException.class, () -> depositDistributionService.distribute(List.of(item)));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

}