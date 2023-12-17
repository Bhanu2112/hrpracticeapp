package com.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.entity.Job;
@Repository
public interface JobRepository extends JpaRepository<Job,String>{

}
