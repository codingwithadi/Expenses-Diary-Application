package com.expenses.diary.application.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "expense_category")
public class ExpenseCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expenseCategoryId;

	private String expenseCategoryName;

//	// Relationship with user
//	@ManyToOne
//	@JoinColumn(name = "user_details")
//	private User user;
	
	// Relationship with expenseDetails
	@OneToMany(mappedBy = "expenseCategory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ExpenseDetails> expenseDetails = new ArrayList<>();
}
