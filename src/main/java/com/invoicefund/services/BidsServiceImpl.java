package com.invoicefund.services;

import com.invoicefund.models.Bid;
import com.invoicefund.repositories.BidRepository;
import com.invoicefund.services.interfaces.BidService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidsServiceImpl implements BidService {

    private final BidRepository bidRepository;

    public BidsServiceImpl(BidRepository bidRepository) {
        this.bidRepository = bidRepository;
    }

    @Override
    public List<Bid> getAllBids() {
        return bidRepository.findAll();
    }
}
