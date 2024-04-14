package com.example.invoices.model;

import lombok.Data;

@Data
public class InvoiceLineItemDto {
    private String deliveryNumber;
    private String title;
    private String unit;
    private Float amount;
    private Float price;
}
