package com.hr.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.dto.EmployeeDTO;
import com.hr.entity.Employee;
import com.hr.entity.Job;
import com.hr.repository.EmployeeRepository;
import com.hr.service.EmployeeService;

import jakarta.validation.Valid;


@RestController
@RequestMapping(path="/api/v1/employees" ,produces = "application/json")
@CrossOrigin
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	EmployeeService employeeService;

	
	@GetMapping()
	public Collection<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/findfname/{firstname}")
	public ResponseEntity<List<Employee>> getFirstName(@PathVariable("firstname")String firstName) {
		List<Employee>  employeeList= employeeRepository.findByFirstName(firstName);
		return new ResponseEntity<>(employeeList,HttpStatus.OK);
	}
	
	@GetMapping("/findemail/{email}")
	public ResponseEntity<Employee> getEmail(@Valid @PathVariable String email ){
		Employee employee = employeeRepository.findByEmail(email);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/findphone/{phoneNumber}")
	public ResponseEntity<Employee> getPhoneNo(@Valid @PathVariable String phoneNumber ){
		Employee employee = employeeRepository.findByPhoneNumber(phoneNumber);
		return new ResponseEntity<>(employee,HttpStatus.OK);
	}
	
	@GetMapping("/findAllEmployeeWithNoCommission")
	public ResponseEntity<List<Employee>> getAllEmployeeWithNoCommission() {
		List<Employee>  employeeList= employeeRepository.findAllByCommissionPctIsNull();
		return new ResponseEntity<>(employeeList,HttpStatus.OK);
	}
	
	@GetMapping("/listAllEmployees/{departmentId}")
	public ResponseEntity<List<Employee>> getAllEmployeesByDepartment(@PathVariable Long departmentId) {
		List<Employee>  employeeList= employeeRepository.findAllByDepartmentDepartmentId(departmentId);
		return new ResponseEntity<>(employeeList,HttpStatus.OK);
	}
    
	@GetMapping("/employees_department_wisecount")
	public ResponseEntity<List<Object[]>> countAllEmployeesGroupByDepartment(){
		List<Object[]>  employeeList= employeeRepository.countAllEmployeesGroupByDepartmentDepartmentId();
		return new ResponseEntity<List<Object[]>>(employeeList,HttpStatus.OK);
	}
	
	/*@GetMapping("listallmanagerdetails")
	public ResponseEntity<List<Employee>> getAllEmployeesByDepartment() {
		List<Employee>  employeeList= employeeRepository.findAllByDepartmentDepartmentId(departmentId);
		return new ResponseEntity<>(employeeList,HttpStatus.OK);
	}*/
	
	@GetMapping("/locationwisecountofemployees")
	public ResponseEntity<List<Object[]>> countAllEmployeesGroupByLocation() {
		List<Object[]>  employeeList= employeeRepository.countAllEmployeesGroupByLocation();
		return new ResponseEntity<List<Object[]>>(employeeList,HttpStatus.OK);
	}
	
	/*@GetMapping("/{employeeId}/findmaxsalaryofjob")
	public ResponseEntity<Long> findMaxSalaryOfJobByEmployeeId(@PathVariable Long employeeId){
		Long maxSalary = employeeRepository.findMaxSalaryOfJobByEmployeeId(employeeId);
		return new ResponseEntity<> (maxSalary,HttpStatus.OK);
	}*/
	
	/*@GetMapping("/findAllOpenPositions/{departmentId}")
	public ResponseEntity<List<Job>> findAllOpenPositionsByDepartment(@PathVariable("departmentId") Long departmentId) {
		List<Job>  jobList= employeeRepository.findAllOpenPositionsByDepartment(departmentId);
		return new ResponseEntity<>(jobList,HttpStatus.OK);
	}*/
	
	@GetMapping("/listallemployeebyhiredate/{fromHireDate}/{toHireDate}")
	public ResponseEntity<List<Employee>> getAllEmployeesByHireDateRange
	   (@PathVariable LocalDate fromHireDate,@PathVariable LocalDate toHireDate){
		List<Employee> employeeList= employeeRepository.findAllByHireDateBetween(fromHireDate,toHireDate);
		return new ResponseEntity<>(employeeList,HttpStatus.OK);
	}
	
	@PostMapping
	ResponseEntity<String> addEmployee(@RequestBody Employee employee){
	 try {
		 employeeService.saveEmployee(employee);
		 return new ResponseEntity<>("Record Created Successfully",HttpStatus.CREATED);
	 }catch (Exception e) {
		 return new ResponseEntity<>(e.getMessage(),HttpStatus.CREATED);
	}
		
		
	}
	
	@PutMapping()
	ResponseEntity<String> modifyEmployee(@Valid @RequestBody Employee employee){
		 employeeService.modifyEmployee(employee);
		 return new ResponseEntity<>("Record Modified Successfully",HttpStatus.OK);	
		}
	
	@PutMapping("/{jobId}")
	ResponseEntity<String> assignEmployeeJob(@Valid @RequestBody Employee employee, @PathVariable String jobId){
		 employeeService.updateEmployeeJobId(employee,jobId);
		 return new ResponseEntity<>("Record Modified Successfully",HttpStatus.OK);
			
		}
	
	@PutMapping("/{managerId}")
	ResponseEntity<String> assignEmployeeManager(@Valid @RequestBody Employee employee, @PathVariable Long managerId){
		 employeeService.assignEmployeeManager(employee,managerId);
		 return new ResponseEntity<>("Record Modified Successfully",HttpStatus.OK);
			
		}
	
	@PutMapping("/{departmentId}")
	ResponseEntity<String> assignEmployeeDepartment(@Valid @RequestBody Employee employee, @PathVariable Long departmentId){
		 employeeService.assignEmployeeManager(employee,departmentId);
		 return new ResponseEntity<>("Record Modified Successfully",HttpStatus.OK);
			
		}
	
	
	
	@GetMapping("/all")
	public ResponseEntity<List<EmployeeDTO>> getAllEmp(){
		 return new ResponseEntity<>(employeeService.getAllEmp(),HttpStatus.OK);
	}
	
}