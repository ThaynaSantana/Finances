package com.thayna.finances.controller;

import com.thayna.finances.entity.Invoice;
import com.thayna.finances.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.findAllInvoices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        Optional<Invoice> invoice = invoiceService.findInvoiceById(id);
        return invoice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody Invoice invoice) {
        return new ResponseEntity<>(invoiceService.saveInvoice(invoice), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Invoice> updateInvoice(@PathVariable Long id, @RequestBody Invoice invoice) {
        if (!invoiceService.findInvoiceById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoice.setId(id);
        return ResponseEntity.ok(invoiceService.saveInvoice(invoice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        if (!invoiceService.findInvoiceById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}
