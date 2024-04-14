package com.example.invoices.utils;

import com.example.invoices.model.DeliveryLineItemDto;
import com.example.invoices.model.InvoiceCheckDto;
import com.example.invoices.model.InvoiceCheckResultDto;
import com.example.invoices.model.InvoiceLineItemDto;
import com.example.invoices.repository.delivery.DeliveryLineRepository;
import com.example.invoices.repository.invoice.InvoiceLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchingService {

    private final DeliveryLineRepository deliveryLineRepository;
    private final InvoiceLineRepository invoiceLineRepository;

    public InvoiceCheckResultDto checkMatch(Long invoiceId) {

        InvoiceCheckResultDto invoiceCheckResult = new InvoiceCheckResultDto();

        List<InvoiceLineItemDto> invoiceLineItems = invoiceLineRepository.findInvoiceLineItemsByInvoiceId(invoiceId);
        for(InvoiceLineItemDto invoiceLineItem: invoiceLineItems){
            String deliveryNumber = invoiceLineItem.getDeliveryNumber();
            List<DeliveryLineItemDto> deliveryLineItems =  deliveryLineRepository.findDeliveryLineItemsByDeliveryNumber(deliveryNumber);
            boolean matchResult = invoiceItemMatchesDeliveries(invoiceLineItem, deliveryLineItems);
            invoiceCheckResult.getInvoiceLinesChecked().add(new InvoiceCheckDto(invoiceId, deliveryNumber, matchResult));
        }

        return invoiceCheckResult;
    }

    private boolean invoiceItemMatchesDeliveries(InvoiceLineItemDto invoiceLineItem, List<DeliveryLineItemDto> deliveryLineItems) {
        //check
        if(!areTitlesSimilar(invoiceLineItem.getTitle(), deliveryLineItems )){
            return false;
        }
        if(!areUnitSimilar(invoiceLineItem.getUnit(), deliveryLineItems)) {
            return false;
        }

        return isAmountEqual(invoiceLineItem.getAmount(), deliveryLineItems);
    }

    private boolean isAmountEqual(Float amount, List<DeliveryLineItemDto> deliveryLineItems) {
        return false;
    }

    private boolean areUnitSimilar(String unit, List<DeliveryLineItemDto> deliveryLineItems) {
        return false;
    }

    private boolean areTitlesSimilar(String title, List<DeliveryLineItemDto> deliveryLineItems) {
        return false;
    }

}
