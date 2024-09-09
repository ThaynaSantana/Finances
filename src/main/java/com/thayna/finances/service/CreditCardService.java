package com.thayna.finances.service;

import com.thayna.finances.entity.CreditCard;
import com.thayna.finances.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CreditCardService {

    @Autowired
    private CreditCardRepository creditCardRepository;

    public List<CreditCard> findAllCreditCards() {
        return creditCardRepository.findAll();
    }

    public Optional<CreditCard> findCreditCardById(Long id) {
        return creditCardRepository.findById(id);
    }

    public CreditCard saveCreditCard(CreditCard creditCard) {
        return creditCardRepository.save(creditCard);
    }

    public void deleteCreditCard(Long id) {
        creditCardRepository.deleteById(id);
    }
}
