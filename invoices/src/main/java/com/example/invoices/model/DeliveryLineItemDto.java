package com.example.invoices.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryLineItemDto {
    private String title;
    private String unit;
    private Float amount;
}
