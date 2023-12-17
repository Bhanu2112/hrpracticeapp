package com.hr.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.dto.JobDTO;
import com.hr.entity.Job;
import com.hr.repository.JobRepository;

@Service
public class JobServiceImpl implements JobService{
	
	@Autowired
	JobRepository jobRepository;
	
	public List<JobDTO> selectJob(){
		List<Job> jobs = jobRepository.findAll();
		List<JobDTO> list = new ArrayList<>();
		for(Job j : jobs) {
			JobDTO dto = new JobDTO();
			dto.setJobId(j.getJobId());
			dto.setJobTitle(j.getJobTitle());
		}
		return list;
	}
	


}
