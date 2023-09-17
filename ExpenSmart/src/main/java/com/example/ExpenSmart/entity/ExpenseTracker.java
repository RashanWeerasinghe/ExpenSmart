package com.example.ExpenSmart.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
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


private String expense_name;

private String description;

private BigDecimal expense_amount;

private String category;

private Date date;
}
