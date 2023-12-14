package com.example.ExpenSmart.service.impl;

import com.example.ExpenSmart.Exception.ExpenseNotFoundException;
import com.example.ExpenSmart.entity.ExpenseTracker;
import com.example.ExpenSmart.repo.ExpenseRepository;
import com.example.ExpenSmart.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public Page<ExpenseTracker> getAllExpenses(Pageable page) {
        return expenseRepository.findAll(page);
    }

    @Override
    public ExpenseTracker getExpenseById(Long id) throws ExpenseNotFoundException{

        Optional<ExpenseTracker>expenseTracker=expenseRepository.findById(id);

        if (expenseTracker.isPresent()) {
            return expenseTracker.get();
        }
        throw new ExpenseNotFoundException("Expense is not found for the id "+id);

    }

    @Override
    public void deleteExpenseById(Long id) {
        ExpenseTracker expenseTracker=getExpenseById(id);
        expenseRepository.delete(expenseTracker);
    }

    @Override
    public ExpenseTracker saveExpenseDetails(ExpenseTracker expenseTracker) {

        return expenseRepository.save(expenseTracker);
    }

    @Override
    public ExpenseTracker updateExpenseDetails(long id, ExpenseTracker expenseTracker) {

        ExpenseTracker ex1=getExpenseById(id);
        ex1.setCategory(expenseTracker.getCategory()!=null?expenseTracker.getCategory(): ex1.getCategory());
        ex1.setExpense_name(expenseTracker.getExpense_name()!=null?expenseTracker.getExpense_name(): ex1.getExpense_name());
        ex1.setExpense_amount(expenseTracker.getExpense_amount()!=null?expenseTracker.getExpense_amount():ex1.getExpense_amount());
        ex1.setDescription(expenseTracker.getDescription()!=null?expenseTracker.getDescription():ex1.getDescription());
        ex1.setDate(expenseTracker.getDate()!=null?expenseTracker.getDate():ex1.getDate());
        return expenseRepository.save(ex1);

    }

    @Override
    public List<ExpenseTracker> readByCategory(String category, Pageable page) {
        return expenseRepository.findByUserIdAndCategory(category, page).toList();
    }

    @Override
    public List<ExpenseTracker> readByName(String keyword, Pageable page) {

        return expenseRepository.findByUserIdAndNameContaining(keyword, page).toList();
    }
}
