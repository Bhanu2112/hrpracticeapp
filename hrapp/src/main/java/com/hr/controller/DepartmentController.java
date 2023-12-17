package com.hr.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.dto.DepartmentDTO;
import com.hr.entity.Department;
import com.hr.repository.DepartmentRepository;
import com.hr.service.DepartmentService;


@RequestMapping("/api/v1/department")
@RestController
public class DepartmentController {
	  
	@Autowired
	private DepartmentService departmentService;
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@GetMapping("/all")
	public List<Department> getAll(){
		return departmentRepository.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<String> addNewDepartment(@RequestBody Department department){
		
		return new ResponseEntity<String>(departmentService.addNewDepartment(department),HttpStatus.OK);
		
	}
	
	@PutMapping()
	public ResponseEntity<String> updateDepartment(@RequestBody Department department){
		return new ResponseEntity<String>(departmentService.updateDepartment(department),HttpStatus.OK);
	}
	
	@GetMapping("/findminsalary/{id}")
	public ResponseEntity<Object> findMinSalaryInDepartment(@PathVariable Long id){
		return new ResponseEntity<Object>(departmentService.findMinSalaryInDepartment(id),HttpStatus.OK);
	}
	
	@GetMapping("/findmaxsalary/{id}")
	public ResponseEntity<Object> findMaxSalaryInDepartment(@PathVariable Long id){
		return new ResponseEntity<Object>(departmentService.findMaxSalaryInDepartment(id),HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteDepartment(Long id){
		boolean delete = departmentService.deleteDepartmentById(id);
		if(delete) {
			return new ResponseEntity("Record deleted Successfully",HttpStatus.OK);
		} else {
			return new ResponseEntity("Location not found", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{empid}")
	public ResponseEntity<List<Department>> getAllEmployeeWorkedDepartments(@PathVariable Long empid){
		return new ResponseEntity<List<Department>>(departmentService.getAllDepartmentsEmployeeWorked(empid),HttpStatus.OK);
	}
	
	

	
	    
	  
}
