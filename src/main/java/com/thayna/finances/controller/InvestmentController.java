package com.thayna.finances.controller;

import com.thayna.finances.entity.Investment;
import com.thayna.finances.service.InvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    @Autowired
    private InvestmentService investmentService;

    @GetMapping
    public List<Investment> getAllInvestments() {
        return investmentService.findAllInvestments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Investment> getInvestmentById(@PathVariable Long id) {
        Optional<Investment> investment = investmentService.findInvestmentById(id);
        return investment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Investment> createInvestment(@RequestBody Investment investment) {
        return new ResponseEntity<>(investmentService.saveInvestment(investment), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Investment> updateInvestment(@PathVariable Long id, @RequestBody Investment investment) {
        if (!investmentService.findInvestmentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        investment.setId(id);
        return ResponseEntity.ok(investmentService.saveInvestment(investment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvestment(@PathVariable Long id) {
        if (!investmentService.findInvestmentById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        investmentService.deleteInvestment(id);
        return ResponseEntity.noContent().build();
    }
}
