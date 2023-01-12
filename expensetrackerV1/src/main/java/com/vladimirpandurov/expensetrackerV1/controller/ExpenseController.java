package com.vladimirpandurov.expensetrackerV1.controller;

import com.vladimirpandurov.expensetrackerV1.model.Expense;
import com.vladimirpandurov.expensetrackerV1.service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,RequestMethod.DELETE})
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
    @PostMapping("")
    public ResponseEntity<Expense> saveExpenses(@RequestBody Expense expense){
        Expense savedExpense = expenseService.save(expense);
        return new ResponseEntity<Expense>(savedExpense, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Expense> findById(@PathVariable("id") Long id){
        Expense expense = this.expenseService.findById(id);
        return new ResponseEntity<Expense>(expense, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        this.expenseService.delete(id);
        return new ResponseEntity<>("Expense is deleted successfully.!",HttpStatus.OK);
    }
}
