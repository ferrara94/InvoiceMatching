package com.example.invoices.entity.delivery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "DELIVERY")
public class Delivery {

    @Id
    Long id;

    String delivery_number;

    public Delivery() {
    }

    public Delivery(Long id, String delivery_number) {
        this.id = id;
        this.delivery_number = delivery_number;
    }
}
