package com.thayna.finances.service;

import com.thayna.finances.entity.Transaction;
import com.thayna.finances.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    // Total de despesas por categoria para um usuário específico
    public Map<String, BigDecimal> getExpensesByCategory(Long userId) {
        List<Transaction> transactions = transactionRepository.findByUserId(userId);

        return transactions.stream()
                .filter(transaction -> "EXPENSE".equals(transaction.getType()))
                .collect(Collectors.groupingBy(
                        Transaction::getCategory,
                        Collectors.reducing(
                                BigDecimal.ZERO,
                                transaction -> BigDecimal.valueOf(transaction.getAmount()),
                                BigDecimal::add
                        )
                ));
    }

    // Total de receitas para um usuário específico
    public BigDecimal getTotalRevenue(Long userId) {
        List<Transaction> transactions = transactionRepository.findByUserId(userId);

        return transactions.stream()
                .filter(transaction -> "INCOME".equals(transaction.getType()))
                .map(transaction -> BigDecimal.valueOf(transaction.getAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Total de despesas para um usuário específico
    public BigDecimal getTotalExpenses(Long userId) {
        List<Transaction> transactions = transactionRepository.findByUserId(userId);

        return transactions.stream()
                .filter(transaction -> "EXPENSE".equals(transaction.getType()))
                .map(transaction -> BigDecimal.valueOf(transaction.getAmount()))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    // Saldo total (receitas - despesas) para um usuário específico
    public BigDecimal getTotalBalance(Long userId) {
        BigDecimal totalRevenue = getTotalRevenue(userId);
        BigDecimal totalExpenses = getTotalExpenses(userId);
        return totalRevenue.subtract(totalExpenses);
    }
}
