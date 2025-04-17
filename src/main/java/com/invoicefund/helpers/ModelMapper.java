package com.invoicefund.helpers;

import com.invoicefund.models.Auction;
import com.invoicefund.models.Bid;
import com.invoicefund.models.Invoice;
import com.invoicefund.models.User;
import com.invoicefund.models.dto.AuctionDtoOut;
import com.invoicefund.models.dto.BidDtoOut;
import com.invoicefund.models.dto.InvoiceDtoOut;
import com.invoicefund.models.dto.UserDtoOut;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ModelMapper {

    public ModelMapper() {
    }

    public UserDtoOut fromUserToUserDtoOut(User user) {
        return new UserDtoOut(
                user.getUsername(),
                user.getFirstName()
        );
    }

    public InvoiceDtoOut fromInvoiceToInvoiceDtoOut(Invoice invoice) {
        return new InvoiceDtoOut(
                invoice.getDescription()
        );
    }

    public AuctionDtoOut fromAuctionToAuctionDtoOut(Auction auction) {
        return new AuctionDtoOut(
                auction.getStartPrice().toString()
        );
    }

    public BidDtoOut fromBidToBidDtoOut(Bid bid) {
        return new BidDtoOut(
                bid.getAmount().toString()
        );
    }

    public List<InvoiceDtoOut> fromListInvoiceToListInvoiceDtoOut(List<Invoice> invoiceList) {
        if (invoiceList == null) {
            return new ArrayList<>();
        }

        return invoiceList.stream()
                .map(invoice -> new InvoiceDtoOut(invoice.getDescription()))
                .collect(Collectors.toList());
    }

    public List<AuctionDtoOut> fromListAuctionToListAuctionDtoOut(List<Auction> auctionList) {
        if (auctionList == null) {
            return new ArrayList<>();
        }

        return auctionList.stream()
                .map(auction -> new AuctionDtoOut(auction.getStartPrice().toString()))
                .collect(Collectors.toList());
    }


    public List<BidDtoOut> fromListBidToListBidDtoOut(List<Bid> bidList) {
        if (bidList == null) {
            return new ArrayList<>();
        }

        return bidList.stream()
                .map(bid -> new BidDtoOut(bid.getAmount().toString()))
                .collect(Collectors.toList());
    }
}
