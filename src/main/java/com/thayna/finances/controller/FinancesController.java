package com.thayna.finances.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class FinancesController {

    private double saldoReal = 1234.56;

    @GetMapping("/saldo")
    public Map<String, Double> obterSaldo() {
        Map<String, Double> response = new HashMap<>();
        response.put("saldo", saldoReal);
        return response;
    }
}
