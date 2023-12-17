package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.hr.entity.Region;
import com.hr.service.RegionService;

@RequestMapping("/api/v1")
@RestController
public class RegionController {

	@Autowired
	private RegionService regionService;
	
	@PostMapping("/region")
	public ResponseEntity<String> addNewRegion(@RequestBody Region region) {
		return new ResponseEntity<String>(regionService.addNewRegion(region), HttpStatus.OK);
	}
	

	@PutMapping("/region")
	public ResponseEntity<String> updateRegion(@RequestBody Region region) {
		return new ResponseEntity<String>(regionService.updateRegion(region), HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/region")
	public ResponseEntity<List<Region>> getAll() {
		return new ResponseEntity<List<Region>>(regionService.getAllRegions(), HttpStatus.OK);
	}
	
	
	@GetMapping("/region/{id}")
	public ResponseEntity<Region> getRegionById(@PathVariable Long id) {
		return new ResponseEntity<>(regionService.getRegionById(id), HttpStatus.OK);
	}

	@DeleteMapping("/region/{id}")
	public ResponseEntity<?> deleteRegionById(@PathVariable Long id) {
		boolean deleted = regionService.deleteRegionById(id);
		if (deleted) {
			return new ResponseEntity("Record deleted Sucessfully",HttpStatus.OK);
		} else {
			return new ResponseEntity("Region not found", HttpStatus.NOT_FOUND);
		}
	}
	   
}
