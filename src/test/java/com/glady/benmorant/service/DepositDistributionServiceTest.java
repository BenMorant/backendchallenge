package com.glady.benmorant.service;

import com.glady.benmorant.exception.NotEnoughBalanceException;
import com.glady.benmorant.model.Company;
import com.glady.benmorant.model.Gift;
import com.glady.benmorant.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DepositDistributionServiceTest {

    private DepositDistributionService depositDistributionService;

    @Test
    void should_distribute_gift_with_positive_balance() {
        // GIVEN
        LocalDate distributionDate = LocalDate.now();
        Gift gift = new Gift(100L, distributionDate);
        Company tesla = new Company("Tesla", 200L);
        User john = new User("John", 0L);
        depositDistributionService = new DepositDistributionService(tesla, john);
        // WHEN
        depositDistributionService.distribute(gift);
        // THEN
        assertEquals(100L, john.getBalance());
        assertEquals(100L, tesla.getBalance());

    }

    @Test
    void should_throw_notEnoughBalanceException() {
        // GIVEN
        LocalDate distributionDate = LocalDate.now();
        Gift gift = new Gift(100L, distributionDate);
        Company tesla = new Company("Tesla", 50L);
        User john = new User("John", 0L);
        depositDistributionService = new DepositDistributionService(tesla, john);
        String expectedMessage = "Tesla has not enough balance.";
        // WHEN, THEN
        Exception exception = assertThrows(NotEnoughBalanceException.class, () -> depositDistributionService.distribute(gift));
       String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));

    }

}