package com.invoicefund.controllers;

import com.invoicefund.helpers.ModelMapper;
import com.invoicefund.models.Auction;
import com.invoicefund.models.dto.AuctionDtoOut;
import com.invoicefund.services.interfaces.AuctionService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auctions")
public class AuctionRestController {

    private final AuctionService auctionService;
    private final ModelMapper modelMapper;

    public AuctionRestController(AuctionService auctionService, ModelMapper modelMapper) {
        this.auctionService = auctionService;
        this.modelMapper = modelMapper;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping()
    public List<AuctionDtoOut> getAllAuctions() {
        List<Auction> auctionList = auctionService.getAllAuctions();
        return modelMapper.fromListAuctionToListAuctionDtoOut(auctionList);
    }
}
