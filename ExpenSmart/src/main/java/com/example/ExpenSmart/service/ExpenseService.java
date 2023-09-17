package com.example.ExpenSmart.service;

import com.example.ExpenSmart.entity.ExpenseTracker;

import java.util.List;

public interface ExpenseService {
    public List<ExpenseTracker> getAllExpenses();

    ExpenseTracker getExpenseById(Long id);
}
