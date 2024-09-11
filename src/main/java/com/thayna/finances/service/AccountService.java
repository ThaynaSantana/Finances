package com.thayna.finances.service;

import com.thayna.finances.entity.Account;
import com.thayna.finances.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> findAllAccounts() {
        return accountRepository.findAll();
    }

    public Optional<Account> findAccountById(Long id) {
        return accountRepository.findById(id);
    }

    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public List<Account> getAccountsByUserId(Long userId){
        return accountRepository.findByUserId(userId);
    }

    public BigDecimal getTotalBalance(Long userID) {
        List<Account> accounts = findAccountsByUserId(userId);
        return accounts.stream()
                .map(Account::getBalance)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalRevenue(Long userId) {
        List<Account> accounts = findAccountsByUserId(userId);
        return accounts.stream()
                    .filter(account -> "REVENUE".equals(account.getType()))
                    .map(Account::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public BigDecimal getTotalExpenses(Long userId) {
        List<Account> accounts = findAccountsByUserId(userId);
        return accounts.stream()
                    .filter(account -> "EXPENSE".equals(account.getType()))
                    .map(Account::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
