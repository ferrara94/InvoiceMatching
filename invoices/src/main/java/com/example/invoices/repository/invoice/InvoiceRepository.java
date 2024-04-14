package com.example.invoices.repository.invoice;

import com.example.invoices.entity.invoice.Invoice;
import com.example.invoices.model.InvoiceDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    @Query("select new com.example.invoices.model.InvoiceDto(i.id, items) " +
            "from Invoice as i " +
            "join fetch InvoiceLineItem as items " +
            "where i.id = :invoiceId"
    )
    public InvoiceDto getInvoiceById(@Param("invoiceId") Long invoiceId);
}
