package com.invoicefund.services.interfaces;

import com.invoicefund.models.Invoice;

import java.util.List;

public interface InvoiceService {

    List<Invoice> getAllInvoices();
}
