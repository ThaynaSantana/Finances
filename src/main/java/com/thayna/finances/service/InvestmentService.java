package com.thayna.finances.service;

import com.thayna.finances.entity.Investment;
import com.thayna.finances.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentService {

    @Autowired
    private InvestmentRepository investmentRepository;

    public List<Investment> findAllInvestments() {
        return investmentRepository.findAll();
    }

    public Optional<Investment> findInvestmentById(Long id) {
        return investmentRepository.findById(id);
    }

    public Investment saveInvestment(Investment investment) {
        return investmentRepository.save(investment);
    }

    public void deleteInvestment(Long id) {
        investmentRepository.deleteById(id);
    }
}
