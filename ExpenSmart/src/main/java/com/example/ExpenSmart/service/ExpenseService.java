package com.example.ExpenSmart.service;

import com.example.ExpenSmart.entity.ExpenseTracker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ExpenseService {
    public Page<ExpenseTracker> getAllExpenses(Pageable page);

    ExpenseTracker getExpenseById(Long id);

    void deleteExpenseById(Long id);

    ExpenseTracker saveExpenseDetails(ExpenseTracker expenseTracker);

    ExpenseTracker updateExpenseDetails(long id, ExpenseTracker expenseTracker);

    List<ExpenseTracker> readByCategory(String category, Pageable page);

    List<ExpenseTracker> readByName(String keyword, Pageable page);
}
