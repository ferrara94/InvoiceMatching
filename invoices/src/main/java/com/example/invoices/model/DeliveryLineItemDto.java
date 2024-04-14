package com.example.invoices.model;

import lombok.Data;

@Data
public class DeliveryLineItemDto {
    private String title;
    private String unit;
    private Float amount;
}
