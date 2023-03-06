package com.expenses.diary.application.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.diary.application.dto.ExpenseCategoryDTO;
import com.expenses.diary.application.entities.ExpenseCategory;
import com.expenses.diary.application.exceptions.ResourceNotFoundException;
import com.expenses.diary.application.repo.ExpenseCategoryRepo;
import com.expenses.diary.application.service.ExpenseCategoryServices;

@Service
public class ExpenseCategoryServiceImpl implements ExpenseCategoryServices{
	
	@Autowired
	private ExpenseCategoryRepo expenseCategoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ExpenseCategoryDTO createExpenseCategory(ExpenseCategoryDTO expenseCategoryDTO) {
		ExpenseCategory expenseCategory = this.modelMapper.map(expenseCategoryDTO, ExpenseCategory.class);
		ExpenseCategory saved = this.expenseCategoryRepo.save(expenseCategory);
		ExpenseCategoryDTO eCategoryDTO = this.modelMapper.map(saved, ExpenseCategoryDTO.class);
		
		return eCategoryDTO;
	}

	@Override
	public ExpenseCategoryDTO updateExpenseCategory(ExpenseCategoryDTO expenseCategoryDTO, Integer categoryId) {
		ExpenseCategory expenseCategory = this.expenseCategoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "ID", categoryId));
		expenseCategory.setExpenseCategoryName(expenseCategoryDTO.getExpenseCategoryName());
		
		ExpenseCategory updatedCategory = this.expenseCategoryRepo.save(expenseCategory);
		ExpenseCategoryDTO eCategoryDTO = this.modelMapper.map(updatedCategory, ExpenseCategoryDTO.class);
		return eCategoryDTO;
	}

	@Override
	public List<ExpenseCategoryDTO> getAllExpenseCategory() {
		List<ExpenseCategory> listOfCategory = this.expenseCategoryRepo.findAll();
		List<ExpenseCategoryDTO> eCategoryDTO = listOfCategory.stream().map((eListOfCategory)-> this.modelMapper.map(eListOfCategory, ExpenseCategoryDTO.class)).collect(Collectors.toList());
		return eCategoryDTO;
	}

	@Override
	public ExpenseCategoryDTO getExpenseCategoryById(Integer categoryId) {
		ExpenseCategory expenseCategory = this.expenseCategoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "ID", categoryId));
		ExpenseCategoryDTO eCategoryDTO = this.modelMapper.map(expenseCategory, ExpenseCategoryDTO.class);
		return eCategoryDTO;
	}

	@Override
	public void deleteExpenseCategoryById(Integer categoryId) {
		ExpenseCategory expenseCategory = this.expenseCategoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "ID", categoryId));
		this.expenseCategoryRepo.delete(expenseCategory);
		
	}

	@Override
	public void deleteAllExpenseCategory() {
		this.expenseCategoryRepo.deleteAll();
		
	}

}
