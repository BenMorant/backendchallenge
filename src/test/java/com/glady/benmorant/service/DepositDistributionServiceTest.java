package com.glady.benmorant.service;

import com.glady.benmorant.model.Company;
import com.glady.benmorant.model.Gift;
import com.glady.benmorant.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

class DepositDistributionServiceTest {

    private DepositDistributionService depositDistributionService;

    @Test
    void should_distribute_gift_with_positive_balance() {
        // GIVEN
        Company tesla = new Company("Tesla", 200L);
        LocalDate distributionDate = LocalDate.now();
        Gift gift = new Gift(100L, distributionDate);
        User john = new User("John");
        depositDistributionService = new DepositDistributionService(tesla, john);
        // WHEN
        depositDistributionService.distribute(gift);
        // THEN
        Assertions.assertEquals(100L, john.getBalance());
        Assertions.assertEquals(100L, tesla.getBalance());

    }

}