package com.example.invoices.model;

import lombok.Data;

import java.util.List;

@Data
public class DeliveryDto {
    private Long id;
    private String deliveryNumber;
    private List<DeliveryLineItemDto> deliveryLineItems;
}
