package com.empmgmt.service;

import java.util.List;

import javax.persistence.EntityExistsException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmgmt.model.Employee;
import com.empmgmt.repository.EmployeeRepository;

@Service
public class EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	public Employee saveEmployee(Employee emp) {
		if(emp.getId()!= null) {
			throw new EntityExistsException("There is already an employee there with same id");
		}
		return employeeRepository.save(emp);
	}
	
	public Employee updateEmployee(Employee emp) {
		if(emp.getId()== null) {
			throw new EntityExistsException("There is no employee there with this id");
		}
		return employeeRepository.save(emp);
	}
	
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}
	
}
