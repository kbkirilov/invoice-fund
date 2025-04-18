package com.invoicefund.controllers;

import com.invoicefund.exceptions.EntityNotFoundException;
import com.invoicefund.helpers.ModelMapper;
import com.invoicefund.models.Auction;
import com.invoicefund.models.Bid;
import com.invoicefund.models.Invoice;
import com.invoicefund.models.User;
import com.invoicefund.models.dto.AuctionDtoOut;
import com.invoicefund.models.dto.BidDtoOut;
import com.invoicefund.models.dto.InvoiceDtoOut;
import com.invoicefund.models.dto.UserDtoOut;
import com.invoicefund.services.interfaces.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/admin-portal")
public class AdminRestController {

    private final ModelMapper modelMapper;
    private final AdminService adminService;
    private final AuctionService auctionService;
    private final BidService bidService;
    private final InvestorService investorService;
    private final InvoiceService invoiceService;
    private final UserService userService;
    private final VendorService vendorService;

    public AdminRestController(ModelMapper modelMapper, AdminService adminService, AuctionService auctionService, BidService bidService,
                               InvestorService investorService, InvoiceService invoiceService, UserService userService,
                               VendorService vendorService) {
        this.modelMapper = modelMapper;
        this.adminService = adminService;
        this.auctionService = auctionService;
        this.bidService = bidService;
        this.investorService = investorService;
        this.invoiceService = invoiceService;
        this.userService = userService;
        this.vendorService = vendorService;
    }

}














































