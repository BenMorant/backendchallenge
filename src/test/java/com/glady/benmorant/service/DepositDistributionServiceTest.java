package com.glady.benmorant.service;

import com.glady.benmorant.exception.NotEnoughBalanceException;
import com.glady.benmorant.model.Company;
import com.glady.benmorant.model.Gift;
import com.glady.benmorant.model.Item;
import com.glady.benmorant.model.User;
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
        Item item = new Gift(100L, distributionDate);
        Company tesla = new Company("Tesla", 200L);
        User john = new User("John");
        depositDistributionService = new DepositDistributionService(tesla, john);
        // WHEN
        depositDistributionService.distribute(List.of(item));
        // THEN
        assertEquals(100L, john.getBalance());
        assertEquals(100L, tesla.getBalance());

    }

    @Test
    void should_throw_notEnoughBalanceException_when_item_amount_bigger_than_company_balance() {
        // GIVEN
        LocalDate distributionDate = LocalDate.now();
        Item item = new Gift(100L, distributionDate);
        Company tesla = new Company("Tesla", 50L);
        User john = new User("John");
        depositDistributionService = new DepositDistributionService(tesla, john);
        String expectedMessage = "Tesla has not enough balance.";
        // WHEN, THEN
        Exception exception = assertThrows(NotEnoughBalanceException.class, () -> depositDistributionService.distribute(List.of(item)));
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

}