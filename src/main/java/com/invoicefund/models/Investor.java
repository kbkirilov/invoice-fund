package com.invoicefund.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "investors")
public class Investor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "company_name")
    private String company_name;

    @OneToMany(mappedBy = "investor")
    private Set<Bid> bids;

}
