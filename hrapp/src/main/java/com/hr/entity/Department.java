package com.hr.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
@Table(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Department{

    @Id
    @NotNull
    @Column(name = "department_id")
    private Long departmentId;

    @NotNull
    @Column(name = "department_name")
    private String departmentName;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name ="manager_id")
    private Employee manager;
    

    
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;
    

    
    }
