package com.empmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.empmgmt.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	}
