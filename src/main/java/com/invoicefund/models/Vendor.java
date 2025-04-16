package com.invoicefund.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "vendors")
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "vendor")
    private Set<Invoice> invoices;

    @OneToMany(mappedBy = "vendor")
    private Set<Auction> auctions;
}
