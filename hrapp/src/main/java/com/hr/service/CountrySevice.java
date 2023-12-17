package com.hr.service;

import java.util.List;

import com.hr.entity.Country;

public interface CountrySevice {
	public String addNewCountry(Country country);
	public String updateCountry(Country country);
	public List<Country> getAllCountries();
	public boolean deleteCountryById(String Id);
	public Country getCountryById(String Id);
}
