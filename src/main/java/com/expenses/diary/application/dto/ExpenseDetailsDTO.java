package com.expenses.diary.application.dto;

import java.util.Date;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ExpenseDetailsDTO {

	private int Id;

	@NotEmpty
	@NotNull
	private String location;

	@NotEmpty
	@Size(min = 10, max = 10, message = "Incorrect date format !! -> Example of Date Format: 20/01/2023")
	private String date;

	private String itemName;

	private String vendorName;

	private int totalExpense;

	private String expenseType;

	private String aboutNote;
	private Date creationDate;
	private Date updationDate;

}
