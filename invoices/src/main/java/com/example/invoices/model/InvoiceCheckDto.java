package com.example.invoices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCheckDto {
    private Long invoiceId;
    private String deliveryNumber;
    private boolean isMatched;
}
