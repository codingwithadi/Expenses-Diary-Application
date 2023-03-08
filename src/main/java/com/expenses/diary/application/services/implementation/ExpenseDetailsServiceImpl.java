package com.expenses.diary.application.services.implementation;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expenses.diary.application.dto.ExpenseDetailsDTO;
import com.expenses.diary.application.entities.ExpenseCategory;
import com.expenses.diary.application.entities.ExpenseDetails;
import com.expenses.diary.application.entities.User;
import com.expenses.diary.application.exceptions.ResourceNotFoundException;
import com.expenses.diary.application.repo.ExpenseCategoryRepo;
import com.expenses.diary.application.repo.ExpenseDetailsRepo;
import com.expenses.diary.application.repo.UserRepo;
import com.expenses.diary.application.service.ExpenseDetailsServices;

@Service
public class ExpenseDetailsServiceImpl implements ExpenseDetailsServices {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ExpenseCategoryRepo expenseCategoryRepo;

	@Autowired
	private ExpenseDetailsRepo expenseDetailsRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ExpenseDetailsDTO createExpenseDetails(Integer userId, Integer categoryId,
			ExpenseDetailsDTO expenseDetailsDTO) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));

		ExpenseCategory category = this.expenseCategoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "ID", categoryId));

		ExpenseDetails expenseDetails = this.modelMapper.map(expenseDetailsDTO, ExpenseDetails.class);

		expenseDetails.setCreationDate(new Date());
		expenseDetails.setUpdationDate(new Date());
		expenseDetails.setUser(user);
		expenseDetails.setExpenseCategory(category);

		ExpenseDetails savedDetails = this.expenseDetailsRepo.save(expenseDetails);

		ExpenseDetailsDTO detailsDTO = this.modelMapper.map(savedDetails, ExpenseDetailsDTO.class);
		return detailsDTO;
	}

	@Override
	public ExpenseDetailsDTO updateExpenseDetails(ExpenseDetailsDTO expenseDetailsDTO, Integer expenseId) {
		ExpenseDetails expenseDetails = this.expenseDetailsRepo.findById(expenseId)
				.orElseThrow(() -> new ResourceNotFoundException("Expense Details", "ID", expenseId));

		expenseDetails.setLocation(expenseDetailsDTO.getLocation());
		expenseDetails.setDate(expenseDetailsDTO.getDate());
		expenseDetails.setItemName(expenseDetailsDTO.getItemName());
		expenseDetails.setVendorName(expenseDetailsDTO.getVendorName());
		expenseDetails.setTotalExpense(expenseDetailsDTO.getTotalExpense());
		expenseDetails.setExpenseType(expenseDetailsDTO.getExpenseType());
		expenseDetails.setAboutNote(expenseDetailsDTO.getAboutNote());
		expenseDetails.setUpdationDate(new Date());

		ExpenseDetails updateExpenseDetails = this.expenseDetailsRepo.save(expenseDetails);
		ExpenseDetailsDTO detailsDTO = this.modelMapper.map(updateExpenseDetails, ExpenseDetailsDTO.class);

		return detailsDTO;
	}

	@Override
	public List<ExpenseDetailsDTO> getAllExpenseDetails() {
		List<ExpenseDetails> listOfDetails = this.expenseDetailsRepo.findAll();
		List<ExpenseDetailsDTO> listOfDetailsDTO = listOfDetails.stream()
				.map((eExpenseDetailsDTO) -> this.modelMapper.map(eExpenseDetailsDTO, ExpenseDetailsDTO.class))
				.collect(Collectors.toList());

		return listOfDetailsDTO;
	}

	@Override
	public List<ExpenseDetailsDTO> getExpenseDetailsByUserId(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "ID", userId));
		List<ExpenseDetails> listOfDetails = this.expenseDetailsRepo.findByUser(user);
		List<ExpenseDetailsDTO> listOfDetailsDTO = listOfDetails.stream()
				.map((eExpenseDetailsDTO) -> this.modelMapper.map(eExpenseDetailsDTO, ExpenseDetailsDTO.class))
				.collect(Collectors.toList());

		return listOfDetailsDTO;
	}

	@Override
	public ExpenseDetailsDTO getExpenseDetailsId(Integer expenseId) {
		ExpenseDetails expenseDetails = this.expenseDetailsRepo.findById(expenseId)
				.orElseThrow(() -> new ResourceNotFoundException("Expense Details", "ID", expenseId));
		ExpenseDetailsDTO detailsDTO = this.modelMapper.map(expenseDetails, ExpenseDetailsDTO.class);
		return detailsDTO;
	}

	@Override
	public void deleteExpenseDetailsById(Integer expenseId) {
		ExpenseDetails expenseDetails = this.expenseDetailsRepo.findById(expenseId)
				.orElseThrow(() -> new ResourceNotFoundException("Expense Details", "ID", expenseId));
		this.expenseDetailsRepo.delete(expenseDetails);
	}

	@Override
	public void deleteAllExpenseDetails() {
		this.expenseDetailsRepo.deleteAll();

	}

}
