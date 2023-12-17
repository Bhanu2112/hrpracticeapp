package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hr.entity.Job;
import com.hr.repository.JobRepository;
@RestController
public class JobController {
	   @Autowired
	    private JobRepository jobRepository;
	    
	   @GetMapping("/alljobs")
	   public List<Job> getAll(){
		   return jobRepository.findAll();
	   }
	   
	   @GetMapping("/job/{Id}")
	   public Job getJob(@PathVariable String Id) {
		   return jobRepository.findById(Id).get();
	   }
}
