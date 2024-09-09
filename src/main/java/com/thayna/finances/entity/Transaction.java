package com.thayna.finances.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private Double amount;
    private String type;
    private String date;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;
}