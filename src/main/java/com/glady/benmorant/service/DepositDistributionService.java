package com.glady.benmorant.service;

import com.glady.benmorant.exception.NotEnoughBalanceException;
import com.glady.benmorant.model.Company;
import com.glady.benmorant.model.Item;
import com.glady.benmorant.model.User;

import java.util.List;

public class DepositDistributionService {

    private final Company company;

    private final User user;

    public DepositDistributionService(Company company, User user) {
        this.company = company;
        this.user = user;
    }

    public void distribute(List<Item> items) {
        items.forEach(item -> {
            long newCompanyBalance = company.getBalance() - item.getAmount();
            if (newCompanyBalance >= 0) {
                company.setBalance(newCompanyBalance);
                user.setBalance(user.getBalance() + item.getAmount());
            } else {
                throw new NotEnoughBalanceException(company.getName() + " has not enough balance.");
            }
        });
    }
}
