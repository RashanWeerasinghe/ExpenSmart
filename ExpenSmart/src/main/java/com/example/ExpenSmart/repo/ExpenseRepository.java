package com.example.ExpenSmart.repo;

import com.example.ExpenSmart.entity.ExpenseTracker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseTracker,Long> {

}
