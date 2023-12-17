package com.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.hr.entity.Country;
import com.hr.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountrySevice {

	@Autowired
	CountryRepository countryRepository;

	public String addNewCountry(Country country) {
		try {
			countryRepository.save(country);
			return "Record Created Sucessfully";
		} catch (Exception e) {
			return "Validation Failed";
		}
	}

	public String updateCountry(Country country) {
		Optional<Country> optionalCountry = countryRepository.findById(country.getCountryId());
		if (optionalCountry.isPresent()) {
			countryRepository.save(country);
			return "Record Modified Sucessfully";
		} else {
			return "Validation Failed";
		}
	}

	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}

	public boolean deleteCountryById(String Id) {
		try {
			countryRepository.deleteById(Id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Country getCountryById(String Id) {
		return countryRepository.findById(Id).get();
	}
}
