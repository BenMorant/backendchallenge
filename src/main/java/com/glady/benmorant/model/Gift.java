package com.glady.benmorant.model;

import java.time.LocalDate;

public class Gift {

    private long amount;

    private LocalDate distributionDate;

    public Gift(long amount, LocalDate distributionDate) {
        this.amount = amount;
        this.distributionDate = distributionDate;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public LocalDate getDistributionDate() {
        return distributionDate;
    }

    public void setDistributionDate(LocalDate distributionDate) {
        this.distributionDate = distributionDate;
    }
}
