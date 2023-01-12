package com.vladimirpandurov.expensetrackerV1.service;


import com.vladimirpandurov.expensetrackerV1.model.Expense;
import com.vladimirpandurov.expensetrackerV1.repository.ExpenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public List<Expense> findAll() {
        return expenseRepository.findAll();
    }
}
