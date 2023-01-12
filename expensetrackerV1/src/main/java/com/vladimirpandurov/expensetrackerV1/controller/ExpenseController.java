package com.vladimirpandurov.expensetrackerV1.controller;

import com.vladimirpandurov.expensetrackerV1.model.Expense;
import com.vladimirpandurov.expensetrackerV1.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/expenses")
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
    @GetMapping("")
    public ResponseEntity<List<Expense>> getExpenses() {
        List<Expense> expenses = expenseService.findAll();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }
}