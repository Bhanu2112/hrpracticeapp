package com.hr.service;

import java.util.List;

import com.hr.entity.Location;

public interface LocationService {

	public String addNewLocation(Location location);
	public String updateLocation(Location location);
	public List<Location> getAllLocations();
	public boolean deleteLocationById(Long Id);
	public Location getLocationById(Long Id);
}
