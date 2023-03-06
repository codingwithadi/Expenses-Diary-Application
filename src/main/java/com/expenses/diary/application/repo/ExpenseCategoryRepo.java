package com.expenses.diary.application.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenses.diary.application.entities.ExpenseCategory;

public interface ExpenseCategoryRepo extends JpaRepository<ExpenseCategory, Integer>{

}
