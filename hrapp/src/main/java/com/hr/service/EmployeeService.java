package com.hr.service;

import java.util.List;

import com.hr.dto.EmployeeDTO;
import com.hr.dto.ManagerDTO;
import com.hr.entity.Employee;

public interface EmployeeService {
  
	boolean saveEmployee(Employee e);
	boolean modifyEmployee(Employee e);
	boolean updateEmployeeJobId(Employee e,String jobId);
	boolean assignEmployeeManager(Employee e,Long managerId);
	boolean assignEmployeeDepartment(Employee e,Long departmentId);
	boolean updateEmployeeEmail(String email);
	public List<EmployeeDTO> getAllEmp();
	
	public List<Employee> getAllEmployees();
	public List<ManagerDTO> selectManager();
}
