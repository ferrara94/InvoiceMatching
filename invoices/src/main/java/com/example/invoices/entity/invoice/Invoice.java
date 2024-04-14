package com.example.invoices.entity.invoice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "INVOICE")
public class Invoice {

    @Id
    Long id;

    public Invoice() {
    }

    public Invoice(Long id) {
        this.id = id;
    }
}
