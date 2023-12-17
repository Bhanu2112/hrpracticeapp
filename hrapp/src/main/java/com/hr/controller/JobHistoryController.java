package com.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.entity.JobHistory;
import com.hr.repository.JobHistoryRepository;
@RestController
public class JobHistoryController {
	   	@Autowired
	    private JobHistoryRepository jobHistoryRepository;
	    
	   @GetMapping("/alljobhistory")
	   public List<JobHistory> getAll(){
		   return jobHistoryRepository.findAll();
	   }
}
