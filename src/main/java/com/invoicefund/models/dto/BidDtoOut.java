package com.invoicefund.models.dto;

import java.math.BigDecimal;

public class BidDtoOut {

    private String amount;

    public BidDtoOut(String amount) {
        this.amount = amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
