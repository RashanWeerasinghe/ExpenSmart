package com.example.ExpenSmart.repo;

import com.example.ExpenSmart.entity.ExpenseTracker;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.stream.Collectors;

@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseTracker,Long> {



    @Query(
            value = "SELECT * FROM tbl_expenses WHERE category=?1",nativeQuery = true)
    Page<ExpenseTracker> findByUserIdAndCategory(String category, Pageable page);

    @Query(
            value = "SELECT * FROM tbl_expenses WHERE expense_name like %?1%",nativeQuery = true)
    Page<ExpenseTracker> findByUserIdAndNameContaining(String keyword, Pageable page);

    @Query(
            value = "SELECT * FROM tbl_expenses WHERE date  BETWEEN %?1% AND %?2%",nativeQuery = true)
    Page<ExpenseTracker> findByUserIdAndDateBetween(Date startDate, Date endDate, Pageable page);
}
