package com.example.ExpenSmart.repo;

import com.example.ExpenSmart.entity.ExpenseTracker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseTracker,Long> {



    @Query(
            value = "SELECT * FROM tbl_expenses WHERE category=?1",nativeQuery = true)
    Page<ExpenseTracker> findByUserIdAndCategory(String category, Pageable page);
}
