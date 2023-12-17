package com.hr.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hr.entity.Employee;
import com.hr.entity.Job;

import jakarta.validation.Valid;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	List<Employee> findByFirstName(String firstName);

	Employee findByEmail(@Valid String email);

	Employee findByPhoneNumber(@Valid String phoneNumber);

	List<Employee> findAllByCommissionPctIsNull();

	List<Employee> findAllByDepartmentDepartmentId(Long departmentId);

	List<Employee> findAllByHireDateBetween(LocalDate fromHireDate, LocalDate toHireDate);

	@Query("SELECT e.department.departmentName department, COUNT(e) count FROM Employee e GROUP BY e.department.departmentId")
	List<Object[]> countAllEmployeesGroupByDepartmentDepartmentId();
    
	@Query("select e.department.location , count(e) from Employee e group by e.department.location")
	List<Object[]> countAllEmployeesGroupByLocation();
  
	/*@Query("select e.job from employee e where e.job.jobId NOT IN e.department")
	List<Job> findAllOpenPositionsByDepartment(Long departmentId); */
    
	/*Long findMaxSalaryOfJobByEmployeeId(@Param("employeeId") Long employeeId);*/
	
	

}
