package com.thayna.finances.service;

import com.thayna.finances.entity.Transaction;
import com.thayna.finances.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.math.BigDecimal;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }

    public Optional<Transaction> findTransactionById(Long id) {
        return transactionRepository.findById(id);
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public void deleteTransaction(Long id) {
        transactionRepository.deleteById(id);
    }

    public Map<String, BigDecimal> getExpensesByCategory(Long userIde) {
        List<Transaction> transactions = transactionRepository.findByUserId(userId);

        return transactions.stream()
                .filter(transaction - > transaction.getType() == TransactionType.EXPENSE)
                .collect(Collectors.groupinBy(
                    Transacation::getCategory,
                    Collectors.mapping(
                        Transacation::getAmount,
                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
                    )
                ));
    }

}
