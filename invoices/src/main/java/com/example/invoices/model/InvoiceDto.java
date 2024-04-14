package com.example.invoices.model;

import com.example.invoices.entity.invoice.InvoiceLineItem;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class InvoiceDto {
    private Long id;
    private List<InvoiceLineItemDto> invoiceLineItems;

    public InvoiceDto(Long id, List<InvoiceLineItem> items) { //it refers to the native query
        this.id = id;
    }
}
