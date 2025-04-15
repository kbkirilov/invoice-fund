package com.invoicefund.models;

import jakarta.persistence.*;

@Entity
@Table(name = "debtors")
public class Debtor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "company_name")
    private String company_name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;
}
