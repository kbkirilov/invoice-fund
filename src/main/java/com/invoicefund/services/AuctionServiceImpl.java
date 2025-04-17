package com.invoicefund.services;

import com.invoicefund.models.Auction;
import com.invoicefund.repositories.AuctionRepository;
import com.invoicefund.services.interfaces.AuctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;

    @Autowired
    public AuctionServiceImpl(AuctionRepository auctionRepository) {
        this.auctionRepository = auctionRepository;
    }

    @Override
    public List<Auction> getAllAuctions() {
        return auctionRepository.findAll();
    }
}
