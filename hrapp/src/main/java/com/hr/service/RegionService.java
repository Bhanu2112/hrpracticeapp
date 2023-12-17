package com.hr.service;

import java.util.List;

import com.hr.entity.Country;
import com.hr.entity.Region;

public interface RegionService {
	public String addNewRegion(Region region);
	public String updateRegion(Region region);
	public List<Region> getAllRegions();
	public boolean deleteRegionById(Long Id);
	public Region getRegionById(Long Id);
}
