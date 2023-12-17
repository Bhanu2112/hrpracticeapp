package com.hr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LocationDTO {

	
	 private Long locationId;

	  
	    private String streetAddress;

	    
	    private String postalCode;

	  
	    private String city;

	  
	    private String stateProvince;

	       private CountryDTO country;
	    
	  
}
