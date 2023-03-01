package com.expenses.diary.application.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExpenseDetailsDTO {

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
}
