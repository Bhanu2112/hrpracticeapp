package com.hr.dto;

import java.time.LocalDate;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobHistoryDTO {

	   private EmployeeDTO employee;
	    
	    
	   
	    private Long employeeId;

	   
	    private Date startDate;

	   
	    private LocalDate endDate;
	    
	    
	      private JobDTO job;
	    
	

	 
	     private DepartmentDTO department;
	    
	  

}
