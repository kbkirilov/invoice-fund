package com.invoicefund.repositories;

import com.invoicefund.models.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VendorRepository extends JpaRepository<Vendor, Integer> {

    List<Vendor> id(int id);

    Optional<Vendor> getVendorByUserId(int id);

}
