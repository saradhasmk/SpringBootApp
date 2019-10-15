package com.empmgmt.DAO;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empmgmt.model.Employee;
import com.empmgmt.repository.EmployeeRepository;
@Service
public class EmployeeDAO {
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired  
    private SessionFactory sessionFactory;  
	
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	
	
	  public boolean deleteStudent(Employee employee) {  
	        boolean status=false;  
	        try {  
	            sessionFactory.getCurrentSession().delete(employee);  
	            status=true;  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        return status;  
	    }

}
