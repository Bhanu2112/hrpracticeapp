package com.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hr.entity.Country;
@Repository
public interface CountryRepository extends JpaRepository<Country, String>{

}
