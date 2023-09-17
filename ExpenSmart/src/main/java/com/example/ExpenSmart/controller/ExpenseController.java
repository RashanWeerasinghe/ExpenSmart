package com.example.ExpenSmart.controller;

import com.example.ExpenSmart.entity.ExpenseTracker;
import com.example.ExpenSmart.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseController {


    @Autowired
    private ExpenseService expenseService;
    @GetMapping("/expenses")
    public List<ExpenseTracker> getAllExpenses(){
       return expenseService.getAllExpenses();
    }

    @GetMapping("/expenses/{id}")
    public ExpenseTracker getExpenseById(@PathVariable Long id){
        return expenseService.getExpenseById(id);
    }
}