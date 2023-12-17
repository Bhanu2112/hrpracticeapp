package com.hr.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@NotNull
	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "first_name")
	private String firstName;

	@NotNull
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	@Column(name = "email", unique = true)
	private String email;

	@Column(name = "phone_number", length = 20)
	private String phoneNumber;

	@NotNull
	@Column(name = "hire_date")
	private LocalDate hireDate;

	@ManyToOne
	@JoinColumn(name = "job_id")
	private Job job;

	@Column(name = "salary")
	private Double salary;

	@Column(name = "commission_pct")
	private Double commissionPct;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id")
	
	private Employee manager;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "department_id")
	private Department department;

}
