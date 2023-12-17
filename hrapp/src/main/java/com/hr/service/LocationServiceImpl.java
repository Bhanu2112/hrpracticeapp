package com.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.entity.Country;
import com.hr.entity.Location;
import com.hr.repository.CountryRepository;
import com.hr.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {


	@Autowired
	LocationRepository locationRepository;

	public String addNewLocation(Location location) {
		try {
			locationRepository.save(location);
			return "Record Created Sucessfully";
		} catch (Exception e) {
			return "Validation Failed";
		}
	}

	public String updateLocation(Location location) {
		Optional<Location> optionalLocation = locationRepository.findById(location.getLocationId());
		if (optionalLocation.isPresent()) {
			locationRepository.save(location);
			return "Record Modified Sucessfully";
		} else {
			return "Validation Failed";
		}
	}

	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	public boolean deleteLocationById(Long Id) {
		try {
			locationRepository.deleteById(Id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Location getLocationById(Long Id) {
		return locationRepository.findById(Id).get();
	}
}
