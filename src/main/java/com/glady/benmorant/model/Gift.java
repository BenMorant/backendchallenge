package com.glady.benmorant.model;

import java.time.LocalDate;

public class Gift extends Item {

    private final static int LIFESPAN_IN_COMPLETE_DAYS = 364;


    public Gift(long amount, LocalDate distributionDate) {
        super(amount, distributionDate, ItemType.GIFT);
        this.expirationDate = distributionDate.plusDays(LIFESPAN_IN_COMPLETE_DAYS);
    }


}
