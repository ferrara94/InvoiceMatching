package com.example.invoices.entity.delivery;

import com.example.invoices.model.DeliveryLineItemDto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DELIVERY_LINE_ITEM")
@Data
public class DeliveryLineItem {

    @Id
    @GeneratedValue
    Long id;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
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

    public DeliveryLineItem(DeliveryLineItemDto request, Delivery delivery) {
        this.title = request.getTitle();
        this.unit = request.getUnit();
        this.amount = request.getAmount();
        this.delivery = delivery;
    }
}
