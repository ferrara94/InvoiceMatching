package com.example.invoices.repository.invoice;

import com.example.invoices.entity.invoice.Invoice;
import com.example.invoices.entity.invoice.InvoiceLineItem;
import com.example.invoices.model.InvoiceLineItemDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceLineRepository extends JpaRepository<InvoiceLineItem, Long>{

    @Query("select new com.example.invoices.model.InvoiceLineItemDto(item.deliveryNumber, item.title, item.unit, item.amount, item.price) " +
            "from InvoiceLineItem as item " +
            "join item.invoice as invoice " +
            "where invoice.id = :invoiceId ")
    List<InvoiceLineItemDto> findInvoiceLineItemsByInvoiceId(@Param("invoiceId") Long invoiceId);
}
