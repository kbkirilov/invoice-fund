package com.invoicefund.services;

import com.invoicefund.exceptions.EntityNotFoundException;
import com.invoicefund.models.Vendor;
import com.invoicefund.repositories.VendorRepository;
import com.invoicefund.services.interfaces.VendorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorServiceImpl implements VendorService {

    private static final Logger logger = LoggerFactory.getLogger(VendorServiceImpl.class);
    private final VendorRepository vendorRepository;

    @Autowired
    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Vendor getVendorByUserId(int id) {
        logger.debug("Fetching vendor for userId: {}", id);
        return vendorRepository
                .getVendorByUserId(id)
                .orElseThrow(()-> {
                    logger.error("Vendor not found for userId: {}", id);
                    return new EntityNotFoundException("Vendor", id);
                });
    }
}
