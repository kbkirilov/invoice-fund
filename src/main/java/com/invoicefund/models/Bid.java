package com.invoicefund.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "bids")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "amount")
    private BigDecimal amount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Investor investor;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;
}
