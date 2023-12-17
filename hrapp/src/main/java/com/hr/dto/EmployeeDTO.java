package com.hr.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	
	    private Long employeeId;

	  
	    private String firstName;

	    private String lastName;

	    private String email;

	 
	    private String phoneNumber;

	    private LocalDate hireDate;

	  
	       private JobDTO job;
	   

	    private Double salary;

	    
	   
	    private Double commissionPct;
	    
	    
	    
	   
	 
	    private EmployeeDTO manager;
	   

	    private DepartmentDTO department;
}
