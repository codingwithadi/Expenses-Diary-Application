package com.expenses.diary.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.diary.application.dto.ExpenseDetailsDTO;
import com.expenses.diary.application.service.ExpenseDetailsServices;
import com.expenses.diary.application.utility.APIResponse;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/details")
public class ExpenseDetailsController {

	@Autowired
	private ExpenseDetailsServices expenseDetailsServices;

	// POST
	@PostMapping("/user/{userId}/category/{categoryId}/expenseDetails")
	public ResponseEntity<ExpenseDetailsDTO> createDetails(@PathVariable("userId") Integer userId,
			@PathVariable("categoryId") Integer categoryId, @Valid @RequestBody ExpenseDetailsDTO expenseDetailsDTO) {
		ExpenseDetailsDTO createdDeails = this.expenseDetailsServices.createExpenseDetails(userId, categoryId,
				expenseDetailsDTO);
		return new ResponseEntity<ExpenseDetailsDTO>(createdDeails, HttpStatus.CREATED);
	}

	// PUT
	@PutMapping("/{expenseId}/expenseDetails")
	public ResponseEntity<ExpenseDetailsDTO> updateDetails(@Valid @RequestBody ExpenseDetailsDTO expenseDetailsDTO,
			@PathVariable("expenseId") Integer expenseId) {
		ExpenseDetailsDTO updatedDetails = this.expenseDetailsServices.updateExpenseDetails(expenseDetailsDTO,
				expenseId);
		return new ResponseEntity<ExpenseDetailsDTO>(updatedDetails, HttpStatus.OK);
	}

	// GET All
	@GetMapping("/getAllExpense")
	public ResponseEntity<List<ExpenseDetailsDTO>> getAllExpenses() {
		List<ExpenseDetailsDTO> getAllDetails = this.expenseDetailsServices.getAllExpenseDetails();
		return new ResponseEntity<List<ExpenseDetailsDTO>>(getAllDetails, HttpStatus.OK);
	}

	// GET by User ID
	@GetMapping("/user/{userId}/getUserExpense")
	public ResponseEntity<List<ExpenseDetailsDTO>> getExpenseByUser(@PathVariable("userId") Integer userId) {
		List<ExpenseDetailsDTO> getDetails = this.expenseDetailsServices.getExpenseDetailsByUserId(userId);
		return new ResponseEntity<List<ExpenseDetailsDTO>>(getDetails, HttpStatus.OK);
	}

	// GET By Expense ID
	@GetMapping("/{expenseId}/getExpense")
	public ResponseEntity<ExpenseDetailsDTO> getExpenseById(@PathVariable("expenseId") Integer expenseId) {
		ExpenseDetailsDTO getDetails = this.expenseDetailsServices.getExpenseDetailsId(expenseId);
		return new ResponseEntity<ExpenseDetailsDTO>(getDetails, HttpStatus.OK);
	}

	// DELETE By ID
	@DeleteMapping("/{expenseId}/deleteExpense")
	public ResponseEntity<APIResponse> getExpense(@PathVariable("expenseId") Integer expenseId) {
		this.expenseDetailsServices.deleteExpenseDetailsById(expenseId);
		return new ResponseEntity<APIResponse>(new APIResponse("Expense Deleted Successfully!!", true), HttpStatus.OK);
	}

	// DELETE
	@DeleteMapping("/deleteAllExpense")
	public ResponseEntity<APIResponse> deleteAllCategories() {
		this.expenseDetailsServices.deleteAllExpenseDetails();
		return new ResponseEntity<APIResponse>(new APIResponse("All Expenses Deleted Successfully!!", true),
				HttpStatus.OK);
	}

}
