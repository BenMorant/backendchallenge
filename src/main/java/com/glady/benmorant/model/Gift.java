package com.glady.benmorant.model;

import java.time.LocalDate;

public class Gift {

    private Long amount;

    private LocalDate distributionDate;

    public Gift(Long amount, LocalDate distributionDate) {
        this.amount = amount;
        this.distributionDate = distributionDate;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getDistributionDate() {
        return distributionDate;
    }

    public void setDistributionDate(LocalDate distributionDate) {
        this.distributionDate = distributionDate;
    }
}
