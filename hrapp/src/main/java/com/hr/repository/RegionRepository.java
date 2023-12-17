package com.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hr.entity.Region;
@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {

}
