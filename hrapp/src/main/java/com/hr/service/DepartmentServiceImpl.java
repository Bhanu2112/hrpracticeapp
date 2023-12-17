package com.hr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.dto.DepartmentDTO;
import com.hr.entity.Department;
import com.hr.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	DepartmentRepository departmentRepository;

	@Override
	public String addNewDepartment(Department department) {
		try {
			departmentRepository.save(department);
			return "Record Created Successfully";
		}catch (Exception e) {
			return "Validation failed";
		}
		
	}

	@Override
	public String updateDepartment(Department department) {
		
		Optional<Department> optionalDepartment = departmentRepository.findById(department.getDepartmentId());
		if(optionalDepartment.isPresent()) {
			departmentRepository.save(department);
			return "Record Modified Successfully";
		}else {
		
			return "Validation failed";
		}
	}

	@Override
	public Object findMaxSalaryInDepartment(Long departmentId) {
		
		return departmentRepository.findMaxSalaryInDepartment(departmentId);
	}

	@Override
	public Object findMinSalaryInDepartment(Long departmentId) {
		
		return departmentRepository.findMinSalaryInDepartment(departmentId);
	}

	@Override
	public List<Department> getAllDepartmentsEmployeeWorked(Long empid) {
		
		return departmentRepository.getAllDepartmentsEmployeeWorkedByEmployeeId(empid);
	}

	@Override
	public boolean deleteDepartmentById(Long departmentId) {
		try {
			departmentRepository.deleteById(departmentId);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	
	public List<DepartmentDTO> selectDepartment(){
		List<Department> departments = departmentRepository.findAll();
		List<DepartmentDTO> list = new ArrayList<>();
		
		for(Department d:departments) {
			DepartmentDTO dto = new DepartmentDTO();
			dto.setDepartmentId(d.getDepartmentId());
			dto.setDepartmentName(d.getDepartmentName());
			list.add(dto);
		}
		return list;
	}

}
