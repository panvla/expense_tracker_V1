package com.vladimirpandurov.expensetrackerV1.service;

import com.vladimirpandurov.expensetrackerV1.model.Expense;

import java.util.List;

public interface ExpenseService {

    List<Expense> findAll();

}
