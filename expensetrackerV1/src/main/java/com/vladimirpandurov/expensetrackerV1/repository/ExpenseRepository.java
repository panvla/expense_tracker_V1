package com.vladimirpandurov.expensetrackerV1.repository;

import com.vladimirpandurov.expensetrackerV1.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {



}
