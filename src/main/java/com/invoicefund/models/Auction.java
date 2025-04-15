package com.invoicefund.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "auctions")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "start_date")
    private LocalDateTime start_date;

    @Column(name = "end_date")
    private LocalDateTime end_date;

    @Column(name = "start_amount")
    private BigDecimal start_amount;

    @Column(name = "bid_step")
    private BigDecimal bid_step;

    @Column(name = "updated_ad")
    private LocalDateTime updated_ad;

    @Column()
    @Enumerated(EnumType.STRING)
    private int status_id;

    @OneToMany(mappedBy = "auction")
    private Set<Invoice> invoices;

    @OneToMany(mappedBy = "auction")
    private Set<Bid> bids;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Vendor vendor;
}
