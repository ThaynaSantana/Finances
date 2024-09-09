package com.thayna.finances.controller;

import com.thayna.finances.entity.CreditCard;
import com.thayna.finances.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/credit-cards")
public class CreditCardController {

    @Autowired
    private CreditCardService creditCardService;

    @GetMapping
    public List<CreditCard> getAllCreditCards() {
        return creditCardService.findAllCreditCards();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditCard> getCreditCardById(@PathVariable Long id) {
        Optional<CreditCard> creditCard = creditCardService.findCreditCardById(id);
        return creditCard.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CreditCard> createCreditCard(@RequestBody CreditCard creditCard) {
        return new ResponseEntity<>(creditCardService.saveCreditCard(creditCard), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditCard> updateCreditCard(@PathVariable Long id, @RequestBody CreditCard creditCard) {
        if (!creditCardService.findCreditCardById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        creditCard.setId(id);
        return ResponseEntity.ok(creditCardService.saveCreditCard(creditCard));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCreditCard(@PathVariable Long id) {
        if (!creditCardService.findCreditCardById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        creditCardService.deleteCreditCard(id);
        return ResponseEntity.noContent().build();
    }
}
