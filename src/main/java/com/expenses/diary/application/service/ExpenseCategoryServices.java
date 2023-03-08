package com.expenses.diary.application.service;

import java.util.List;

import com.expenses.diary.application.dto.ExpenseCategoryDTO;

public interface ExpenseCategoryServices {

	// create
	ExpenseCategoryDTO createExpenseCategory(ExpenseCategoryDTO expenseCategoryDTO);

	// update
	ExpenseCategoryDTO updateExpenseCategory(ExpenseCategoryDTO expenseCategoryDTO, Integer categoryId);

	// get all
	List<ExpenseCategoryDTO> getAllExpenseCategory();

	// get by id
	ExpenseCategoryDTO getExpenseCategoryById(Integer categoryId);

	// delete by id
	void deleteExpenseCategoryById(Integer categoryId);

	// delete all
	void deleteAllExpenseCategory();

}
