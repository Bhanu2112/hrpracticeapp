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


import com.hr.entity.Location;

import com.hr.service.LocationService;

@RequestMapping("/api/v1/location")
@RestController
public class LocationController {
	  @Autowired
	  private LocationService locationService;

		

		@PostMapping()
		public ResponseEntity<String> addNewLocation(@RequestBody Location location) {
			return new ResponseEntity<String>(locationService.addNewLocation(location), HttpStatus.OK);
		}

		@PutMapping()
		public ResponseEntity<String> updateLocation(@RequestBody Location location) {
			return new ResponseEntity<String>(locationService.updateLocation(location), HttpStatus.OK);
		}

		@GetMapping()
		public ResponseEntity<List<Location>> getAll() {
			return new ResponseEntity<List<Location>>(locationService.getAllLocations(), HttpStatus.OK);
		}

		@GetMapping("/{id}")
		public ResponseEntity<Location> getLocationById(@PathVariable Long Id) {
			return new ResponseEntity<>(locationService.getLocationById(Id), HttpStatus.OK);
		}

		@DeleteMapping("/{id}")
		public ResponseEntity<?> deleteLocationById(@PathVariable Long id) {
			boolean deleted = locationService.deleteLocationById(id);
			if (deleted) {
				return new ResponseEntity("Record deleted Successfully",HttpStatus.OK);
			} else {
				return new ResponseEntity("Location not found", HttpStatus.NOT_FOUND);
			}
		}
}
