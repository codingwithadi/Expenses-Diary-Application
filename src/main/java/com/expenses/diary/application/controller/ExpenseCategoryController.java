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

import com.expenses.diary.application.dto.ExpenseCategoryDTO;
import com.expenses.diary.application.service.ExpenseCategoryServices;
import com.expenses.diary.application.utility.APIResponse;

@RestController
@RequestMapping("api/category")
public class ExpenseCategoryController {

	@Autowired
	private ExpenseCategoryServices expenseCategoryServices;
	
	//POST
	@PostMapping("/createCategory")
	public ResponseEntity<ExpenseCategoryDTO> createCategory(@RequestBody ExpenseCategoryDTO expenseCategoryDTO){
		ExpenseCategoryDTO createCategory = this.expenseCategoryServices.createExpenseCategory(expenseCategoryDTO);
		return new ResponseEntity<ExpenseCategoryDTO>(createCategory, HttpStatus.CREATED);
	}
	
	//PUT
	@PutMapping("/{categoryId}/updateCategory")
	public ResponseEntity<ExpenseCategoryDTO> updateCategory(@RequestBody ExpenseCategoryDTO expenseCategoryDTO, @PathVariable("categoryId") Integer categoryId){
		ExpenseCategoryDTO updateCategory = this.expenseCategoryServices.updateExpenseCategory(expenseCategoryDTO, categoryId);
		return new ResponseEntity<ExpenseCategoryDTO>(updateCategory, HttpStatus.OK);
	}
	
	//GET
	@GetMapping("/getAllCategories")
	public ResponseEntity<List<ExpenseCategoryDTO>> getAllCategories(){
		List<ExpenseCategoryDTO> getAll = this.expenseCategoryServices.getAllExpenseCategory();
		return new ResponseEntity<List<ExpenseCategoryDTO>>(getAll, HttpStatus.OK);
	}
	
	//GET by ID
	@GetMapping("/{categoryId}/getCategory")
	public ResponseEntity<ExpenseCategoryDTO> getCategory(@PathVariable("categoryId") Integer categoryId){
		ExpenseCategoryDTO getCategory = this.expenseCategoryServices.getExpenseCategoryById(categoryId);
		return new ResponseEntity<ExpenseCategoryDTO>(getCategory, HttpStatus.OK);
	}
	
	//DELETE by ID
	@DeleteMapping("/{categoryId}/deleteCategory")
	public ResponseEntity<APIResponse> deleteCategory(@PathVariable("categoryId") Integer categoryId){
		this.expenseCategoryServices.deleteExpenseCategoryById(categoryId);
		return new ResponseEntity<APIResponse>(new APIResponse("Category Deleted Successfully!!", true), HttpStatus.OK);
	}
	
	//DELETE 
	@DeleteMapping("/deleteAllCategories")
	public ResponseEntity<APIResponse> deleteAllCategories(){
		this.expenseCategoryServices.deleteAllExpenseCategory();
		return new ResponseEntity<APIResponse>(new APIResponse("Category Deleted Successfully!!", true), HttpStatus.OK);
	}
	
	
}
