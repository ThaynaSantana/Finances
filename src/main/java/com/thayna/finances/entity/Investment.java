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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetType() {
        return assetType;
    } 

    public void setAssetType(String assetType) {
        this.assetType = assetType;
    }

    public String getInvestmentCategory() {
        return investmentCategory;
    }

    public void setInvestmentCategory(String investmentCategory){
        this.investmentCategory = investmentCategory;
    }

    public Double getTotalInvested() {
        return totalInvested;
    }

    public void setTotalInvested(Double totalInvested) {
        this.totalInvested = totalInvested;
    }

    public String getFixedDate() {
        return fixedDate;
    }

    public void setFixedDate(String fixedDate) {
        this.fixedDate = fixedDate;
    }

    public Double getYield() {
        return yield;
    }

    public void setYield(Double yield) {
        this.yield = yield;
    }
}
