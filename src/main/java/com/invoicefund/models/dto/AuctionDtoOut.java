package com.invoicefund.models.dto;

import java.math.BigDecimal;

public class AuctionDtoOut {

    private String startingPrice;

    public AuctionDtoOut(String startingPrice) {
        this.startingPrice = startingPrice;
    }

    public String getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(String startingPrice) {
        this.startingPrice = startingPrice;
    }
}
