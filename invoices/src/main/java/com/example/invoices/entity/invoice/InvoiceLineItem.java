package com.example.invoices.entity.invoice;

import jakarta.persistence.*;

@Entity
@Table(name = "INVOICE_LINE_ITEM")
public class InvoiceLineItem {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name="invoice_id", nullable=false)
    Invoice invoice;

    String delivery_number;
    String title;
    String unit;
    Float amount;
    Float price;

    public InvoiceLineItem() {
    }

    public InvoiceLineItem(String delivery_number, String title, String unit, Float amount, Float price) {
        this.delivery_number = delivery_number;
        this.title = title;
        this.unit = unit;
        this.amount = amount;
        this.price = price;
    }
}
