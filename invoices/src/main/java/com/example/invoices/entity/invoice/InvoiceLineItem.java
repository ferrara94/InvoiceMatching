package com.example.invoices.entity.invoice;

import jakarta.persistence.*;

@Entity
@Table(name = "INVOICE_LINE_ITEM")
public class InvoiceLineItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="invoice_id", nullable=false)
    private Invoice invoice;

    private String deliveryNumber;
    private String title;
    private String unit;
    private Float amount;
    private Float price;

    public InvoiceLineItem() {
    }

    public InvoiceLineItem(String deliveryNumber, String title, String unit, Float amount, Float price) {
        this.deliveryNumber = deliveryNumber;
        this.title = title;
        this.unit = unit;
        this.amount = amount;
        this.price = price;
    }
}
