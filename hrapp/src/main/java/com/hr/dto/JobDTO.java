package com.hr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobDTO {

	 private String jobId;

	    private String jobTitle;

	  
	    private Long minSalary;

	  
	    private Long maxSalary;
}
