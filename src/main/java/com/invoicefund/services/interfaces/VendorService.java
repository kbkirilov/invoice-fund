package com.invoicefund.services.interfaces;

import com.invoicefund.models.Vendor;

public interface VendorService {

    Vendor getVendorByUserId(int userId);
}
