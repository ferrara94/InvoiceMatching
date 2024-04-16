package com.example.invoices.entity.invoice;

import com.example.invoices.model.InvoiceLineItemDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "INVOICE_LINE_ITEM")
@Data
public class InvoiceLineItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
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

    public InvoiceLineItem(InvoiceLineItemDto request, Invoice invoice) {
        this.deliveryNumber = request.getDeliveryNumber();
        this.title = request.getTitle();
        this.unit = request.getUnit();
        this.amount = request.getAmount();
        this.price = request.getPrice();
        this.invoice = invoice;
    }
}
