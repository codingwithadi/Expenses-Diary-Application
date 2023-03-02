package com.expenses.diary.application.service;

import java.util.List;

import com.expenses.diary.application.dto.ExpenseDetailsDTO;

public interface ExpenseDetailsServices {

	//create
	ExpenseDetailsDTO createExpenseDetails(Integer userId, Integer categoryId, ExpenseDetailsDTO expenseDetailsDTO);
	
	//update
	ExpenseDetailsDTO updateExpenseDetails(ExpenseDetailsDTO expenseDetailsDTO, Integer userId);
	
	//get all
	List<ExpenseDetailsDTO> getALlExpenseDetails();
	
	//get by user-id
	ExpenseDetailsDTO getExpenseDetailsByUserId(ExpenseDetailsDTO expenseDetailsDTO, Integer userId);
	
	//get by id
	ExpenseDetailsDTO getExpenseDetailsId(ExpenseDetailsDTO expenseDetailsDTO, Integer expenseId);
	
	//delete by id
	void deleteExpenseDetailsById(Integer expenseId);
	
	//delete all
	void deleteAllExpenseDetails();
}
