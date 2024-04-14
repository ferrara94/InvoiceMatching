package com.example.invoices.model;

import lombok.Data;

import java.util.List;

@Data
public class InvoiceDto {
    private Long id;
    private List<InvoiceLineItemDto> invoiceLineItems;
}
