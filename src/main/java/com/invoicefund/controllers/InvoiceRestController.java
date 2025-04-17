package com.invoicefund.controllers;

import com.invoicefund.helpers.ModelMapper;
import com.invoicefund.models.Invoice;
import com.invoicefund.models.dto.InvoiceDtoOut;
import com.invoicefund.services.interfaces.InvoiceService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceRestController {

    private final InvoiceService invoiceService;
    private final ModelMapper modelMapper;

    public InvoiceRestController(InvoiceService invoiceService, ModelMapper modelMapper) {
        this.invoiceService = invoiceService;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("invoices")
    public List<InvoiceDtoOut> getAllInvoices() {
        List<Invoice> invoiceList = invoiceService.getAllInvoices();
        return modelMapper.fromListInvoiceToListInvoiceDtoOut(invoiceList);
    }
}
