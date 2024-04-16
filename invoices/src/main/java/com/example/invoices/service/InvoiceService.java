package com.example.invoices.service;

import com.example.invoices.model.DeliveryLineItemDto;
import com.example.invoices.model.InvoiceCheckDto;
import com.example.invoices.model.InvoiceCheckResultDto;
import com.example.invoices.model.InvoiceLineItemDto;
import com.example.invoices.repository.delivery.DeliveryLineRepository;
import com.example.invoices.repository.invoice.InvoiceLineRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class InvoiceService {

    private final DeliveryLineRepository deliveryLineRepository;
    private final InvoiceLineRepository invoiceLineRepository;

    public InvoiceCheckResultDto checkMatch(Long invoiceId) {
        log.info("Checking invoice {}", invoiceId);
        InvoiceCheckResultDto invoiceCheckResult = new InvoiceCheckResultDto();
        List<InvoiceLineItemDto> invoiceLineItems = invoiceLineRepository.findInvoiceLineItemsByInvoiceId(invoiceId);
        log.info("Evaluating {} invoice line items", invoiceLineItems.size());
        for (InvoiceLineItemDto invoiceLineItem : invoiceLineItems) {
            String deliveryNumber = invoiceLineItem.getDeliveryNumber();
            log.info("Verifying invoice line items for delivery number {}", deliveryNumber);
            List<DeliveryLineItemDto> deliveryLineItems = deliveryLineRepository.findDeliveryLineItemsByDeliveryNumber(deliveryNumber);
            if (!deliveryLineItems.isEmpty()) {
                boolean matchResult = invoiceItemMatchesDeliveries(invoiceLineItem, deliveryLineItems);
                invoiceCheckResult.getInvoiceLinesChecked().add(new InvoiceCheckDto(invoiceId, deliveryNumber, matchResult));
            }
        }
        return invoiceCheckResult;
    }

    private boolean invoiceItemMatchesDeliveries(InvoiceLineItemDto invoiceLineItem, List<DeliveryLineItemDto> deliveryLineItems) {
        return deliveryLineItems.stream().anyMatch(d -> isEquals(invoiceLineItem, d));
    }

    private boolean isEquals(InvoiceLineItemDto invoiceLineItem, DeliveryLineItemDto deliveryLineItem) {
        if (!invoiceLineItem.getTitle().equals(deliveryLineItem.getTitle())) return false;
        if (!invoiceLineItem.getUnit().equals(deliveryLineItem.getUnit())) return false;
        if (!invoiceLineItem.getAmount().equals(deliveryLineItem.getAmount())) return false;
        return true;
    }

}
