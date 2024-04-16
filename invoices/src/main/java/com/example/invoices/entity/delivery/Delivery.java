package com.example.invoices.entity.delivery;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "DELIVERY")
@Data
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String deliveryNumber;

    public Delivery() {
    }

    public Delivery(String delivery_number) {
        this.deliveryNumber = delivery_number;
    }
}
