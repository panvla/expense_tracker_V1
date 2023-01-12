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

    @Override
    public Expense save(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense findById(Long id) {
        return this.expenseRepository.findById(id).orElseThrow(null);
    }

    @Override
    public void delete(Long id) {
        Expense expense = this.expenseRepository.findById(id).orElseThrow(null);
        if(expense!= null){
            this.expenseRepository.delete(expense);
        }else{
            System.out.println("nije nadjen");
        }
    }
}
