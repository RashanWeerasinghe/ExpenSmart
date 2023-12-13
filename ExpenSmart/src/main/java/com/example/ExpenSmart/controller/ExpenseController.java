package com.example.ExpenSmart.controller;

import com.example.ExpenSmart.entity.ExpenseTracker;
import com.example.ExpenSmart.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ExpenseController {


    @Autowired
    private ExpenseService expenseService;
    @GetMapping("/expenses")
    public List<ExpenseTracker> getAllExpenses(Pageable page){

        return expenseService.getAllExpenses(page).toList();
    }

    @GetMapping("/expenses/{id}")
    public ExpenseTracker getExpenseById(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @DeleteMapping("/expenses")
    public void deleteExpenseById(@RequestParam Long id){
        expenseService.deleteExpenseById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/expenses")
    public ExpenseTracker saveExpenseDetails(@Valid @RequestBody ExpenseTracker expenseTracker){
        return expenseService.saveExpenseDetails(expenseTracker);
    }

    @PutMapping("/expenses/{id}")
    public ExpenseTracker updateExpenseDetails(@RequestBody ExpenseTracker expenseTracker,@PathVariable long id){
         return expenseService.updateExpenseDetails(id,expenseTracker);

    }

    @GetMapping("/expenses/category")
    public List<ExpenseTracker> getExpensesByCategory(@RequestParam String category, Pageable page){
        return expenseService.readByCategory(category, page);
    }

}