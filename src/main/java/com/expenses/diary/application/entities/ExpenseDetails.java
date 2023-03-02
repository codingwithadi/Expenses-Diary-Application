package com.expenses.diary.application.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "expense_details")
public class ExpenseDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;

	private String location;
	private String date;
	private String itemName;
	private String vendorName;
	private int totalExpense;
	private String expenseType;
	private String aboutNote;
	private Date creationDate;
	private Date updationDate;

	// Relationship with expenseCategory
	@ManyToOne
	@JoinColumn(name = "expense_category")
	private ExpenseCategory expenseCategory;

	// Relationship with user
	@ManyToOne
	@JoinColumn(name = "user_details")
	private User user;

}
