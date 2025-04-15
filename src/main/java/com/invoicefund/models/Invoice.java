package com.invoicefund.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "debtor_id")
    private Debtor debtor;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "description")
    private String description;

    @Column(name = "issue_date")
    private LocalDateTime issue_date;

    @Column(name = "due_date")
    private LocalDateTime due_date;

    @Column()
    @Enumerated(EnumType.STRING)
    private int status_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Vendor vendor;

    @ManyToOne
    @JoinColumn(name = "auction_id")
    private Auction auction;

}
