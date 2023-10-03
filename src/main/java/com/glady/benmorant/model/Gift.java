package com.glady.benmorant.model;

import java.time.LocalDate;

public class Gift extends Item {

    private final static long LIFESPAN_IN_COMPLETE_DAYS = 364L;


    public Gift(long amount, LocalDate distributionDate) {
        super(amount, distributionDate, ItemType.GIFT);
        this.expirationDate = distributionDate.plusDays(LIFESPAN_IN_COMPLETE_DAYS);
    }


}
