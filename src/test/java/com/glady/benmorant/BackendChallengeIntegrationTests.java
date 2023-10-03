package com.glady.benmorant;

import com.glady.benmorant.model.*;
import com.glady.benmorant.service.DepositDistributionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BackendChallengeIntegrationTests {

    private DepositDistributionService depositDistributionService;

    @Test
    void should_give_the_correct_output_for_gift_and_the_correct_user_balance_when_now_is_before_the_expiration_date() {
        // GIVEN
        String expectedOutput = "John receives a Gift distribution with the amount of $100 from Tesla. He will therefore have $100 in gift cards in his account. He received it on 06/15/2021. The gift distribution will expire on 06/14/2022.";
        User user = new User("John", 0L);
        // Todo : new balance to calculate
        long newBalance = 100L;
        LocalDate distributionDate = LocalDate.of(2021, Month.JUNE, 15);
        Item item = new Gift(100L, distributionDate);
        // Todo : expiration date to calculate
        LocalDate expirationDate = LocalDate.of(2022, Month.JUNE, 14);
        // Todo : date formatter should be into an util class or method
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        // Todo : item type enum
        String itemType = "Gift";
        Company company = new Company("Tesla", 200L);
        depositDistributionService = new DepositDistributionService(company, user);
        // WHEN
        depositDistributionService.distribute(item);
        String actualOutput = user.getName() + " receives a " + itemType + " distribution with the amount of $" + item.getAmount() + " from " + company.getName() + ". He will therefore have $" + newBalance + " in gift cards in his account. He received it on " + dtf.format(item.getDistributionDate()) + ". The gift distribution will expire on " + dtf.format(expirationDate) + ".";
        // THEN
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void should_give_the_correct_output_for_meal_and_the_correct_user_balance_when_now_is_before_the_expiration_date() {
        // GIVEN
        String expectedOutput = "Jessica receives a Meal distribution from Apple with the amount of $50 on 01/01/2020, the distribution ends on 02/28/2021.";
        User user = new User("Jessica", 0L);
        // Todo : new balance to calculate
        long newBalance = 50L;
        long expectedBalance = 50L;
        LocalDate distributionDate = LocalDate.of(2020, Month.JANUARY, 1);
        Item item = new Meal(50L, distributionDate);
        // Todo : expiration date to calculate. Caution with leap years !
        LocalDate expirationDate = LocalDate.of(2021, Month.FEBRUARY, 28);
        // Todo : date formatter should be into an util class or method
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu");
        // Todo : item type enum
        String itemType = "Meal";
        Company company = new Company("Apple", 200L);
        depositDistributionService = new DepositDistributionService(company, user);
        // WHEN
        depositDistributionService.distribute(item);
        String actualOutput = user.getName() + " receives a " + itemType + " distribution from " + company.getName() + " with the amount of $" + item.getAmount() + " on " + dtf.format(item.getDistributionDate()) + ", the distribution ends on " + dtf.format(expirationDate) + ".";
        // THEN
        assertEquals(expectedOutput, actualOutput);
        assertEquals(expectedBalance, newBalance);

    }
}