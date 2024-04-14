package com.example.invoices.entity.invoice;

import jakarta.persistence.*;


@Entity
@Table(name = "INVOICE")
public class Invoice {

    @Id
    @GeneratedValue
    Long id;

    public Invoice() {
    }

    public Invoice(Long id) {
        this.id = id;
    }
}
