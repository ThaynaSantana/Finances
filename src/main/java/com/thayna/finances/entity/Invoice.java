package com.thayna.finances.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dueDate; // dt vencimento
    private int numberOfInstallments; // Parcelas defauth: 1
    private Double total;
    private String status; // status: paga, não paga, vencida

    @ManyToOne
    @JoinColumn(name = "credit_card_id", nullable = false)
    private CreditCard creditCard;

    public void getId() {
        return id;
    }

    public Long setId(Long id) {
        this.id = id;
    }

    public void getDueDate() {
        return dueDate;
    }

    public String setDueDate(String dueDate) {
        this.dueDate = dueDate;
    } 

    public void getNumberOfInstallments() {
        return numberOfInstallments;
    }

    public int setNumberOfInstallments(int numberOfInstallments) {
        this.numberOfInstallments = numberOfInstallments;
    }

    public void getTotal() {
        return total;
    }

    public Double setTotal(Double total) {
        this.total = total;
    }

    // valor da parcela
    public Double getTotalOfInstallment() {
        return total/numberOfInstallments;
    }

    public void getStatus() {
        return status;
    }

    public String setStatus(String status) {
        this.status = status;
    }
}