package com.example.invoices.entity.delivery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DELIVERY_LINE_ITEM")
public class DeliveryLineItem {

    @Id
    String dLineId;

    String title;
    String unit;

    Float amount;

    public DeliveryLineItem() {
    }

    public DeliveryLineItem(String dLineId, String title, String unit, Float amount) {
        this.dLineId = dLineId;
        this.title = title;
        this.unit = unit;
        this.amount = amount;
    }
}
