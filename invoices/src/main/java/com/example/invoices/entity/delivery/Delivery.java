package com.example.invoices.entity.delivery;

import jakarta.persistence.*;

@Entity
@Table(name = "DELIVERY")
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    private String deliveryNumber;

    public Delivery() {
    }

    public Delivery(Long id, String delivery_number) {
        this.id = id;
        this.deliveryNumber = delivery_number;
    }
}
