package com.expenses.diary.application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenses.diary.application.entities.ExpenseDetails;
import com.expenses.diary.application.entities.User;

public interface ExpenseDetailsRepo extends JpaRepository<ExpenseDetails, Integer>{

	//find By Custom Find Method.
	List<ExpenseDetails> findByUser(User user);
}
