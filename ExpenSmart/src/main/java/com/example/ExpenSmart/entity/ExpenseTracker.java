package com.example.ExpenSmart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "tbl_expenses")
public class ExpenseTracker {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;

    @NotBlank(message = "Expense name must not be null")
    @Size(min = 3, message = "Expense name must be atleast 3 characters")
private String expense_name;

private String description;
    @NotNull(message = "Expense amount should not be null")
private BigDecimal expense_amount;
    @NotBlank(message = "Category should not be null")
private String category;
    @NotNull(message = "Date must not be null")
private Date date;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;
}
