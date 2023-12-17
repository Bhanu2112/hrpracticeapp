package com.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.hr.entity.JobHistory;
import com.hr.entity.JobHistoryId;
@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {

}
