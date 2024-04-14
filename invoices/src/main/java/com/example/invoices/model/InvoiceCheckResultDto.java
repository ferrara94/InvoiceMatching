package com.example.invoices.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceCheckResultDto {
    private boolean isMatched;
    private List<InvoiceCheckDto> invoiceLinesChecked = new ArrayList<>();

    public boolean isMatched() {
        if(invoiceLinesChecked == null || invoiceLinesChecked.isEmpty()){
            return false;
        }
        return invoiceLinesChecked.stream().allMatch(InvoiceCheckDto::isMatched);
    }
}
