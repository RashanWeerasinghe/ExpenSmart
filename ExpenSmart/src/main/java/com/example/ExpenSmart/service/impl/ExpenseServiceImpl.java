package com.example.ExpenSmart.service.impl;

import com.example.ExpenSmart.entity.ExpenseTracker;
import com.example.ExpenSmart.repo.ExpenseRepository;
import com.example.ExpenSmart.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<ExpenseTracker> getAllExpenses() {
        return expenseRepository.findAll();
    }
}
