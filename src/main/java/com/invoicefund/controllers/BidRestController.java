package com.invoicefund.controllers;

import com.invoicefund.helpers.ModelMapper;
import com.invoicefund.models.Bid;
import com.invoicefund.models.dto.BidDtoOut;
import com.invoicefund.services.interfaces.BidService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bids")
public class BidRestController {

    private final BidService bidService;
    private final ModelMapper modelMapper;

    public BidRestController(BidService bidService, ModelMapper modelMapper) {
        this.bidService = bidService;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public List<BidDtoOut> getAllBids() {
        List<Bid> bidList = bidService.getAllBids();
        return modelMapper.fromListBidToListBidDtoOut(bidList);
    }
}
