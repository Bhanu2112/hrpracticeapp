package com.hr.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hr.entity.Department;
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	 @Query("SELECT d.departmentName AS departmentName, MAX(e.salary) AS maxSalary FROM Employee e JOIN e.department d WHERE d.departmentId = :departmentId GROUP BY d.departmentName")
	    Object findMaxSalaryInDepartment(@Param("departmentId") Long departmentId);

	    @Query("SELECT d.departmentName AS departmentName, MIN(e.salary) AS minSalary FROM Employee e JOIN e.department d WHERE d.departmentId = :departmentId GROUP BY d.departmentName")
	    Object findMinSalaryInDepartment(@Param("departmentId") Long departmentId);
	
	 
	 
	    @Query("SELECT d FROM Department d WHERE d.manager.employeeId = :employeeId")
	    List<Department> getAllDepartmentsEmployeeWorkedByEmployeeId(@Param("employeeId") Long employeeId);
	
}
