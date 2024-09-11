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

    public void getId() {
        return id;
    }

    public Long setId(Long id) {
        this.id = id;
    }

    public void getAssetType() {
        return assetType;
    } 

    public String setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public void getInvestmentCategory() {
        return investmentCategory;
    }

    public String setInvestmentCategory(String investmentCategory){
        this.investmentCategory = investmentCategory;
    }

    public void getTotalInvested() {
        return totalInvested;
    }

    public Double setTotalInvested(Double totalInvested) {
        this.totalInvested = totalInvested;
    }

    public void getFixedDate() {
        return fixedDate;
    }

    public String setFixedDate(String fixedDate) {
        this.fixedDate = fixedDate;
    }

    public void getYield() {
        return yield;
    }

    public Double setYield(Double yield) {
        this.yield = yield;
    }
}
