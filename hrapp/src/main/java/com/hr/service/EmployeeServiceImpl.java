package com.hr.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.dto.DepartmentDTO;
import com.hr.dto.EmployeeDTO;
import com.hr.dto.JobDTO;
import com.hr.dto.ManagerDTO;
import com.hr.entity.Department;
import com.hr.entity.Employee;
import com.hr.entity.Job;
import com.hr.exception.DuplicateEmployeeException;
import com.hr.exception.EmployeeNotFoundException;
import com.hr.repository.DepartmentRepository;
import com.hr.repository.EmployeeRepository;
import com.hr.repository.JobRepository;
import com.hr.util.ErrorResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private JobRepository jobRepositroy;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public boolean saveEmployee(Employee e) {
		Optional<Employee> opt = employeeRepository.findById(e.getEmployeeId());
		if (opt.isPresent()) {
			ErrorResponse response = new ErrorResponse(LocalDate.now(), "Employee Already Exists");
			throw new DuplicateEmployeeException(response);
		}
		employeeRepository.save(e);
		return true;
	}

	@Override
	public boolean modifyEmployee(Employee e) {
		Optional<Employee> opt = employeeRepository.findById(e.getEmployeeId());
		if (opt.isEmpty()) {
			ErrorResponse response = new ErrorResponse(LocalDate.now(), "Employee Not Found");
			throw new EmployeeNotFoundException(response);
		}
		employeeRepository.save(e);
		return true;

	}

	@Override
	public boolean updateEmployeeJobId(Employee e, String jobId) {
		Optional<Employee> opt = employeeRepository.findById(e.getEmployeeId());
		if (opt.isEmpty()) {
			ErrorResponse response = new ErrorResponse(LocalDate.now(), "Employee Not Found");
			throw new EmployeeNotFoundException(response);
		}
		Optional<Job> opt1 = jobRepositroy.findById(jobId);
		if (opt1.isEmpty()) {
			ErrorResponse response = new ErrorResponse(LocalDate.now(), "Job Not Found");
			throw new EmployeeNotFoundException(response);
		}
		Employee employee = opt.get();
		Job job = opt1.get();
		employee.setJob(job);
		employeeRepository.save(employee);
		return true;

	}

	@Override
	public boolean assignEmployeeManager(Employee e, Long managerId) {
		Optional<Employee> opt = employeeRepository.findById(e.getEmployeeId());
		if (opt.isEmpty()) {
			ErrorResponse response = new ErrorResponse(LocalDate.now(), "Employee Not Found");
			throw new EmployeeNotFoundException(response);
		}
		Optional<Employee> opt1 = employeeRepository.findById(managerId);
		if (opt1.isEmpty()) {
			ErrorResponse response = new ErrorResponse(LocalDate.now(), "Manager Not Found");
			throw new EmployeeNotFoundException(response);
		}
		Employee employee = opt.get();
		employee.setManager(opt1.get());
		employeeRepository.save(employee);
		return true;
	}

	@Override
	public boolean assignEmployeeDepartment(Employee e, Long departmentId) {
		Optional<Employee> opt = employeeRepository.findById(e.getEmployeeId());
		if (opt.isEmpty()) {
			ErrorResponse response = new ErrorResponse(LocalDate.now(), "Employee Not Found");
			throw new EmployeeNotFoundException(response);
		}
		Optional<Department> opt1 = departmentRepository.findById(departmentId);
		if (opt.isEmpty()) {
			ErrorResponse response = new ErrorResponse(LocalDate.now(), "Department Not Found");
			throw new EmployeeNotFoundException(response);
		}
		Employee employee = opt.get();
		employee.setDepartment(opt1.get());
		employeeRepository.save(employee);
		return true;
	}

	@Override
	public boolean updateEmployeeEmail(String email) {

		return false;
	}

//	public List<EmployeeDTO> getAllEmp() {
//
//		List<EmployeeDTO> employeeDTOs = new ArrayList<>();
//		List<Employee> employees = employeeRepository.findAll();
//		for (Employee e : employees) {
//			EmployeeDTO edto = new EmployeeDTO();
//			edto.setEmployeeId(e.getEmployeeId());
//			edto.setFirstName(e.getFirstName());
//			edto.setLastName(e.getLastName());
//			edto.setEmail(e.getEmail());
//			edto.setHireDate(e.getHireDate());
//			edto.setCommissionPct(e.getCommissionPct());
//			edto.setPhoneNumber(e.getPhoneNumber());
//			edto.setSalary(e.getSalary());
//			edto.setJob(getJObDTO(e.getJob().getJobId()));
//
//
//			Optional<Employee> m = employeeRepository.findById(e.getEmployeeId());
////			EmployeeDTO mdt = new EmployeeDTO();
//			if (m.isPresent()) {
//				EmployeeDTO mdto = new EmployeeDTO();
//				mdto.setEmployeeId(m.get().getManagerId());
//				mdto.setFirstName(m.get().getFirstName());
//				mdto.setLastName(m.get().getLastName());
//				mdto.setEmail(m.get().getEmail());
////				mdt=mdto;
//				edto.setManager(mdto);
//			} else {
////				mdt = null;
//				edto.setManager(null);
//			}
//			
//			if(e.getDepartmentId()!=null) {
//				
//			
//
//			Optional<Department> d = departmentRepository.findById(e.getDepartmentId());
//
//			if (d.isPresent()) {
//				DepartmentDTO dd = new DepartmentDTO();
//				dd.setDepartmentId(d.get().getDepartmentId());
//				dd.setDepartmentName(d.get().getDepartmentName());
////				dd.setManager(mdt);
//				edto.setDepartment(dd);
//			} else {
//				edto.setDepartment(null);
//			}
//			}
//
//			employeeDTOs.add(edto);
//		}
//
//		return employeeDTOs;
//	}
//	
//	
	
	
	public JobDTO getJObDTO(String JobId) {
		Optional<Job> job = jobRepositroy.findById(JobId);
		if (job.isPresent()) {
			JobDTO jobd = new JobDTO();
			jobd.setJobId(job.get().getJobId());
			jobd.setJobTitle(job.get().getJobTitle());
			jobd.setMaxSalary(job.get().getMaxSalary());
			jobd.setMinSalary(job.get().getMinSalary());
			return jobd;

		} else {
			return null;
		}
	}

	@Override
	public List<EmployeeDTO> getAllEmp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}
	
	
	
	public List<ManagerDTO> selectManager(){
		List<Employee> employees = employeeRepository.findAll();
		List<ManagerDTO> list = new ArrayList<>();
		for(Employee e:employees) {
			ManagerDTO dto = new ManagerDTO();
			dto.setEmployeeId(e.getEmployeeId());
			String name= e.getFirstName()+" "+e.getLastName();
			dto.setName(name);
			list.add(dto);
		}
		return list;
	}
	
	
	

}
