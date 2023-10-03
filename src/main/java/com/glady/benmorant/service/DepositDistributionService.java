package com.glady.benmorant.service;

import com.glady.benmorant.exception.NotEnoughBalanceException;
import com.glady.benmorant.model.Company;
import com.glady.benmorant.model.Gift;
import com.glady.benmorant.model.Item;
import com.glady.benmorant.model.User;

public class DepositDistributionService {

    private Company company;

    private User user;

    public DepositDistributionService(Company company, User user) {
        this.company = company;
        this.user = user;
    }

    public void distribute(Item item) {
        long newCompanyBalance = company.getBalance() - item.getAmount();
        if (newCompanyBalance < 0) {
            throw new NotEnoughBalanceException(company.getName() + " has not enough balance.");
        } else {
            company.setBalance(newCompanyBalance);
            user.setBalance(user.getBalance() + item.getAmount());
        }
    }
}
