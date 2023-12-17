package com.hr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.hr.entity.Department;
import com.hr.entity.Employee;
import com.hr.repository.EmployeeRepository;
import com.hr.service.DepartmentService;
import com.hr.service.EmployeeService;
import com.hr.service.JobService;


@Controller
public class ThyControllrt {
	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@Autowired
	DepartmentService departmentService;
	
	@Autowired
	JobService jobService;
	
	
	
	@GetMapping("/hello")
	String getMessage(Model model) {
	 model.addAttribute("name","Welcome to this");
	 return "hello";
	}
	@GetMapping("/start")
	String getMessageStart(Model model) {
	 model.addAttribute("name","Welcome to this");
	 return "start";
	}
	
	@GetMapping("/emp")
	public String getAllEmployees(Model model) {
		model.addAttribute("employees",employeeService.getAllEmployees());
		return "employees";
	}
	
	
	@GetMapping("/add/employee")
	public String saveEmployeeForm(Model model) {
		
		model.addAttribute("employee", new Employee());
		model.addAttribute("managerObj", new Employee());
		model.addAttribute("departmentObj", new Department());
		model.addAttribute("departments",departmentService.selectDepartment());
		model.addAttribute("managers",employeeService.selectManager());
		return "saveemployee";
	}
	
	
	@PostMapping("/employee/save")
	public String saveEmployee(Employee employee) {
		employeeRepository.save(employee);
		
		return "redirect:/emp";
	}

}
