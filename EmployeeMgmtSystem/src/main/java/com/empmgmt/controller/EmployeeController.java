package com.empmgmt.controller;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.empmgmt.model.Employee;
import com.empmgmt.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	
	@RequestMapping(value="/employees", method=RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value="/employee", method=RequestMethod.GET)
	public List<Employee> getEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> saveEmployees(@RequestBody Employee emp) throws URISyntaxException{
		try {
			Employee result=employeeService.saveEmployee(emp);
			return ResponseEntity.created(new URI("api/employee/"+result.getId())).body(result);
		}
		catch(Exception e) {
			return new ResponseEntity<Employee>(HttpStatus.CONFLICT);
		}
	//	return employeeService.saveEmployee(emp);
	}
}
