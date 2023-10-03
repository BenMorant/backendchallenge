package com.glady.benmorant.service;

import com.glady.benmorant.exception.NotEnoughBalanceException;
import com.glady.benmorant.model.Company;
import com.glady.benmorant.model.Item;

import java.util.List;

public class DepositDistributionService {

    private final Company company;


    public DepositDistributionService(Company company) {
        this.company = company;

    }

    public void distribute(List<Item> items) {
        items.forEach(item -> {
            long newCompanyBalance = company.getBalance() - item.getAmount();
            if (newCompanyBalance >= 0) {
                company.setBalance(newCompanyBalance);
                item.getDestinationUsers().forEach(user -> user.addItem(item));
            } else {
                throw new NotEnoughBalanceException(company.getName() + " has not enough balance for this distribution.");
            }
        });
    }
}
