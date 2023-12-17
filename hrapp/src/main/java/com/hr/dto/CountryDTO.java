package com.hr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {

	

    private String countryId;

   
    private String countryName;

   
    private RegionDTO region;
    
   
}
