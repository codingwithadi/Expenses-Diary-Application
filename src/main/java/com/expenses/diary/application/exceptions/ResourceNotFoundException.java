package com.expenses.diary.application.exceptions;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException{

	private String resourceName;
	private String resourceFeildName;
	private int resourceId;
	
	public ResourceNotFoundException(String resourceName, String resourceFeildName, int resourceId) {
		super(String.format("Oops!! %s NOT FOUND with %s : %s", resourceName, resourceFeildName, resourceId));
		this.resourceName = resourceName;
		this.resourceFeildName = resourceFeildName;
		this.resourceId = resourceId;
	}
	
	
}
