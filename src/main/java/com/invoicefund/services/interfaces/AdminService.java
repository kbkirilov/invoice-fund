package com.invoicefund.services.interfaces;

import com.invoicefund.models.*;

import java.util.List;

public interface AdminService {

    User getUserById(int id);

    List<User> getAllUsers();

    List<Invoice> getAllInvoices();

    List<Auction> getAllAuctions();

    List<Bid> getAllBids();
}
