package com.invoicefund.models.dto;

public class InvoiceDtoOut {

    private String description;

    public InvoiceDtoOut() {
    }

    public InvoiceDtoOut(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
