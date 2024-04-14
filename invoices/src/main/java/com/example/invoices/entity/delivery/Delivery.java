package com.example.invoices.entity.delivery;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "DELIVERY")
public class Delivery {

    @Id
    Long id;

    String delivery_number;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dLineId", cascade = CascadeType.ALL)
    private List<DeliveryLineItem> deliveryLines;

    public Delivery() {
    }

    public Delivery(Long id, String delivery_number) {
        this.id = id;
        this.delivery_number = delivery_number;
    }
}
