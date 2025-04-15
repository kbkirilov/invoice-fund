package com.invoicefund.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
