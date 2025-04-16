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
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "start_amount")
    private BigDecimal startAmount;

    @Column(name = "bid_step")
    private BigDecimal bidStep;

    @Column(name = "updated_ad")
    private LocalDateTime updatedAt;

    @Column(name = "status_id")
    private int statusId;

    @OneToMany(mappedBy = "auction")
    private Set<Invoice> invoices;

    @OneToMany(mappedBy = "auction")
    private Set<Bid> bids;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Vendor vendor;
}
