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
    private String type; // EXPENSE or INCOME = receita ou despesa
    private String dateOfPayment;
    private String dateOfPurchase;
    private String category;
    private String typeExpense // debit or credit

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public void getId() {
        return id;
    }

    public Long setId(Long id) {
        this.id = id;
    }

    public void getDescription() {
        return description;
    }

    public String setDescription(String description) {
        this.description = description;
    }

    public void getAmount(){
        return amount;
    }

    public Double setAmount(Double amount){
        this.amount = amount;
    }

    public void getType(){
        return type;
    }

    public String setType(String type) {
        this.type = type;
    }

    public void getDateOfPayment() {
        return dateOfPayment;
    }

    public String setDateOfPayment(String dateOfPayment) {
        this.dateOfPayment = dateOfPayment;
    }

    public void getDateOfPurchase() {
        return dateOfPurchase;
    }

    public String setDateOfPurchase(String dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void getCategory() {
        return category;
    }

    public String setCategory(String category) {
        this.category = category;
    }

    public void getTypeExpense() {
        return typeExpense;
    }

    public String setTypeExpense(String typeExpense) {
        this.typeExpense = typeExpense;
    }
}