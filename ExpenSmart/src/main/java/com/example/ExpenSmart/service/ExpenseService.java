package com.example.ExpenSmart.service;

import com.example.ExpenSmart.entity.ExpenseTracker;

import java.util.List;

public interface ExpenseService {
    public List<ExpenseTracker> getAllExpenses();

    ExpenseTracker getExpenseById(Long id);

    void deleteExpenseById(Long id);

    ExpenseTracker saveExpenseDetails(ExpenseTracker expenseTracker);

    ExpenseTracker updateExpenseDetails(long id, ExpenseTracker expenseTracker);
}
