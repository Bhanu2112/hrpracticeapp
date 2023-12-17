package com.hr.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.entity.Region;

import com.hr.repository.RegionRepository;

@Service
public class RegionServiceImpl implements RegionService {


	
	@Autowired
	RegionRepository regionRepository;

	public String addNewRegion(Region region) {
		try {
			regionRepository.save(region);
			return "Record Created Sucessfully";
		} catch (Exception e) {
			return "Validation Failed";
		}
	}

	public String updateRegion(Region region) {
		Optional<Region> optionalRegion = regionRepository.findById(region.getRegionId());
		if (optionalRegion.isPresent()) {
			regionRepository.save(region);
			return "Record Modified Sucessfully";
		} else {
			return "Validation Failed";
		}
	}

	public List<Region> getAllRegions() {
		return regionRepository.findAll();
	}

	public boolean deleteRegionById(Long Id) {
		try {
			regionRepository.deleteById(Id);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public Region getRegionById(Long Id) {
		return regionRepository.findById(Id).get();
	}


}
