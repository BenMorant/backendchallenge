package com.glady.benmorant;

import com.glady.benmorant.model.*;
import com.glady.benmorant.service.DepositDistributionService;
import com.glady.benmorant.service.UserBalanceService;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BackendChallengeIntegrationTests {

    private final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu");

    private DepositDistributionService depositDistributionService;

    private UserBalanceService userBalanceService;

    @Test
    void should_give_the_correct_output_for_gift_and_the_correct_user_balance_when_now_is_before_the_expiration_date() {
        // GIVEN
        String expectedOutput = "John receives a Gift distribution with the amount of $100 from Tesla. He will therefore have $100 in gift cards in his account. He received it on 06/15/2021. The gift distribution will expire on 06/14/2022.";
        User user = new User("John");

        LocalDate distributionDate = LocalDate.of(2021, Month.JUNE, 15);
        Clock mockedNow = Clock.fixed(
                Instant.parse("2021-08-22T10:00:00Z"),
                ZoneOffset.UTC);
        Item item = new Gift(100L, distributionDate);
        item.addUsers(List.of(user));
        Company company = new Company("Tesla", 200L);
        depositDistributionService = new DepositDistributionService(company);
        userBalanceService = new UserBalanceService(user, mockedNow);
        // WHEN
        depositDistributionService.distribute(List.of(item));
        userBalanceService.calculateBalance(item);

        String actualOutput = user.getName() + " receives a " + item.getItemType().getName() + " distribution with the amount of $" + item.getAmount() + " from " + company.getName() + ". He will therefore have $" + user.getBalance() + " in gift cards in his account. He received it on " + dtf.format(item.getDistributionDate()) + ". The gift distribution will expire on " + dtf.format(item.getExpirationDate()) + ".";
        // THEN
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void should_give_the_correct_output_for_meal_and_the_correct_user_balance_when_now_is_before_the_expiration_date() {
        // GIVEN
        String expectedOutput = "Jessica receives a Meal distribution from Apple with the amount of $50 on 01/01/2020, the distribution ends on 02/28/2021.";
        User user = new User("Jessica");
        long expectedBalance = 50L;
        LocalDate distributionDate = LocalDate.of(2020, Month.JANUARY, 1);
        Clock mockedNow = Clock.fixed(
                Instant.parse("2020-08-22T10:00:00Z"),
                ZoneOffset.UTC);
        Item item = new Meal(50L, distributionDate);
        item.addUsers(List.of(user));
        Company company = new Company("Apple", 200L);
        depositDistributionService = new DepositDistributionService(company);
        userBalanceService = new UserBalanceService(user, mockedNow);
        // WHEN
        depositDistributionService.distribute(List.of(item));
        userBalanceService.calculateBalance(item);
        String actualOutput = user.getName() + " receives a " + item.getItemType().getName() + " distribution from " + company.getName() + " with the amount of $" + item.getAmount() + " on " + dtf.format(item.getDistributionDate()) + ", the distribution ends on " + dtf.format(item.getExpirationDate()) + ".";
        // THEN
        assertEquals(expectedOutput, actualOutput);
        assertEquals(expectedBalance, user.getBalance());

    }

    @Test
    void should_give_the_correct_output_for_meal_and_the_correct_user_balance_when_now_is_before_the_expiration_date_and_when_leap_year() {
        // GIVEN
        String expectedOutput = "Jessica receives a Meal distribution from Apple with the amount of $50 on 01/01/2023, the distribution ends on 02/29/2024.";
        User user = new User("Jessica");
        long expectedBalance = 50L;
        LocalDate distributionDate = LocalDate.of(2023, Month.JANUARY, 1);
        Clock mockedNow = Clock.fixed(
                Instant.parse("2023-08-22T10:00:00Z"),
                ZoneOffset.UTC);
        Item item = new Meal(50L, distributionDate);
        item.addUsers(List.of(user));
        Company company = new Company("Apple", 200L);
        depositDistributionService = new DepositDistributionService(company);
        userBalanceService = new UserBalanceService(user, mockedNow);
        // WHEN
        depositDistributionService.distribute(List.of(item));
        userBalanceService.calculateBalance(item);
        String actualOutput = user.getName() + " receives a " + item.getItemType().getName() + " distribution from " + company.getName() + " with the amount of $" + item.getAmount() + " on " + dtf.format(item.getDistributionDate()) + ", the distribution ends on " + dtf.format(item.getExpirationDate()) + ".";
        // THEN
        assertEquals(expectedOutput, actualOutput);
        assertEquals(expectedBalance, user.getBalance());

    }
}
