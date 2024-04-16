package com.example.invoices.controller;

import com.example.invoices.entity.delivery.Delivery;
import com.example.invoices.entity.delivery.DeliveryLineItem;
import com.example.invoices.model.DeliveryDto;
import com.example.invoices.model.DeliveryLineItemDto;
import com.example.invoices.repository.delivery.DeliveryLineRepository;
import com.example.invoices.repository.delivery.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/delivery")
@RequiredArgsConstructor
@Slf4j
public class DeliveryController {

    private final DeliveryLineRepository deliveryLineRepository;
    private final DeliveryRepository deliveryRepository;

    @PostMapping
    public ResponseEntity<Long> createDelivery(@RequestBody DeliveryDto request) {
        log.info("Creating delivery for delivery number {}", request.getDeliveryNumber());
        Delivery createdDelivery = deliveryRepository.save(new Delivery(request.getDeliveryNumber()));
        return new ResponseEntity<>(createdDelivery.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/{deliveryId}/delivery-items")
    public ResponseEntity<Long> createDeliveryLineItem(@PathVariable("deliveryId") Long deliveryId,
                                                       @RequestBody DeliveryLineItemDto request) {
        log.info("Creating delivery for delivery {} with title {} and amount {}", deliveryId, request.getTitle(), request.getAmount());
        Optional<Delivery> delivery = deliveryRepository.findById(deliveryId);
        if (delivery.isEmpty()) {
            log.error("Delivery with id {} not found", deliveryId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        DeliveryLineItem createdDeliveryLineItem = deliveryLineRepository.save(new DeliveryLineItem(request, delivery.get()));
        return new ResponseEntity<>(createdDeliveryLineItem.getId(), HttpStatus.CREATED);
    }
}
