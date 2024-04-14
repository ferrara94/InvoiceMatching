package com.example.invoices.entity.delivery;

import jakarta.persistence.*;

@Entity
@Table(name = "DELIVERY_LINE_ITEM")
public class DeliveryLineItem {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name="delivery_id", nullable=false)
    Delivery delivery;

    String title;
    String unit;
    Float amount;

    public DeliveryLineItem() {
    }

    public DeliveryLineItem(String title, String unit, Float amount) {
        this.title = title;
        this.unit = unit;
        this.amount = amount;
    }
}
