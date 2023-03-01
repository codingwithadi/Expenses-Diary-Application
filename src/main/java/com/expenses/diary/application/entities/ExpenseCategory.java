package com.expenses.diary.application.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="expense_category")
public class ExpenseCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int expenseCategoryId;
	
	private String expenseCategoryName;
}
