package com.thayna.finances.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "investments")
public class Investment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetType; // e.g., "CDB", "LCA", "Bitcoin"
    private String investmentCategory; // e.g., "fixed income", "variable income", "crypto"
    private Double totalInvested;
    private String fixedDate; // Fixed date for investment
    private Double yield;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
