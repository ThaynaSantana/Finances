package com.thayna.finances.controller;

import com.thayna.finances.entity.*;
import com.thayna.finances.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.math.BigDecimal;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CreditCardService creditCardService;

    @Autowired
    private TransactionService transactionService;

    @GetMapping("/")
    public String home(Model model) {
        // usuário logado
        User user = userService.getLoggedInUser();

        // Pegar saldo do usuário
        BigDecimal balance = accountService.getTotalBalance(user.getId());
        model.addAttribute("balance", balance);

        // Pegar receitas e despesas
        BigDecimal revenue = transactionService.getTotalRevenue(user.getId());
        BigDecimal expenses = transactionService.getTotalExpenses(user.getId());
        model.addAttribute("revenue", revenue);
        model.addAttribute("expenses", expenses);

        // Listar contas bancárias
        List<Account> accounts = accountService.getAccountsByUserId(user.getId());
        model.addAttribute("accounts", accounts);

        // Listar cartões de crédito
        List<CreditCard> creditCards = creditCardService.getCreditCardsByUserId(user.getId());
        model.addAttribute("creditCards", creditCards);

        // Listar despesas por categoria
        Map<String, BigDecimal> expensesByCategory = transactionService.getExpensesByCategory(user.getId());
        model.addAttribute("expensesByCategory", expensesByCategory);

        return "home"; 
    }
}
