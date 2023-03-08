package com.expenses.diary.application.service;

import java.util.List;

import com.expenses.diary.application.dto.ExpenseDetailsDTO;

public interface ExpenseDetailsServices {

	// create
	ExpenseDetailsDTO createExpenseDetails(Integer userId, Integer categoryId, ExpenseDetailsDTO expenseDetailsDTO);

	// update
	ExpenseDetailsDTO updateExpenseDetails(ExpenseDetailsDTO expenseDetailsDTO, Integer expenseId);

	// get all
	List<ExpenseDetailsDTO> getAllExpenseDetails();

	// get by user-id
	List<ExpenseDetailsDTO> getExpenseDetailsByUserId(Integer userId);

	// get by id
	ExpenseDetailsDTO getExpenseDetailsId(Integer expenseId);

	// delete by id
	void deleteExpenseDetailsById(Integer expenseId);

	// delete all
	void deleteAllExpenseDetails();
}
