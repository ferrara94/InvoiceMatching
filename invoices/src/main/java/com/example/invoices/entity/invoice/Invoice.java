package com.example.invoices.entity.invoice;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Table(name = "INVOICE")
@Data
public class Invoice {

    @Id
    private Long id;

    public Invoice() {
    }

    public Invoice(Long id) {
        this.id = id;
    }
}
