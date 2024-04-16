package com.example.invoices.controller;

import com.example.invoices.entity.invoice.Invoice;
import com.example.invoices.entity.invoice.InvoiceLineItem;
import com.example.invoices.model.InvoiceCheckResultDto;
import com.example.invoices.model.InvoiceDto;
import com.example.invoices.model.InvoiceLineItemDto;
import com.example.invoices.repository.invoice.InvoiceLineRepository;
import com.example.invoices.repository.invoice.InvoiceRepository;
import com.example.invoices.service.InvoiceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/api/invoice")
@RequiredArgsConstructor
@Slf4j
public class InvoiceController {

    private final InvoiceLineRepository invoiceLineRepository;
    private final InvoiceRepository invoiceRepository;
    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<Long> createInvoice(@RequestBody InvoiceDto request) {
        log.info("Creating invoice for invoice id {}", request.getId());
        Invoice createdInvoice = invoiceRepository.save(new Invoice(request.getId()));
        return new ResponseEntity<>(createdInvoice.getId(), HttpStatus.CREATED);
    }

    @PostMapping("/{invoiceId}/invoice-items")
    public ResponseEntity<Long> createInvoiceLineItem(@PathVariable("invoiceId") Long invoiceId,
                                                      @RequestBody InvoiceLineItemDto request) {
        log.info("Creating invoice for invoice {} with title {} and amount {}", invoiceId, request.getTitle(), request.getAmount());
        Optional<Invoice> invoice = invoiceRepository.findById(invoiceId);
        if (invoice.isEmpty()) {
            log.error("Invoice with id {} not found", invoiceId);
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        InvoiceLineItem createdInvoiceLineItem = invoiceLineRepository.save(new InvoiceLineItem(request, invoice.get()));
        return new ResponseEntity<>(createdInvoiceLineItem.getId(), HttpStatus.CREATED);
    }

    @GetMapping("/{invoiceId}/check")
    public ResponseEntity<InvoiceCheckResultDto> checkInvoice(@PathVariable("invoiceId") Long invoiceId) {
        InvoiceCheckResultDto result = invoiceService.checkMatch(invoiceId);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
