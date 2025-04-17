package com.invoicefund.services;

import com.invoicefund.exceptions.EntityNotFoundException;
import com.invoicefund.models.User;
import com.invoicefund.repositories.*;
import com.invoicefund.services.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.invoicefund.helpers.Constants.*;

@Service
public class AdminServiceImpl implements AdminService {

//    private final AdminRepository adminRepository;
//    private final AuctionRepository auctionRepository;
//    private final BidRepository bidRepository;
//    private final InvestorRepository investorRepository;
//    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserById(int id) {
        return userRepository
                .getUserById(id)
                .orElseThrow(()-> new EntityNotFoundException(TYPE_USER, id));
    }
}






























