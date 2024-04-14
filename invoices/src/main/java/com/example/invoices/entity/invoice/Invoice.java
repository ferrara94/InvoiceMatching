package com.example.invoices.entity.invoice;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "INVOICE")
public class Invoice {

    @Id
    Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "iLineId", cascade = CascadeType.ALL)
    private List<InvoiceLineItem> invoiceLines;

    public Invoice() {
    }

    public Invoice(Long id) {
        this.id = id;
    }
}
