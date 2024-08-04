package com.employee.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee createEmployee(Employee employee){
		
	return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee){
		
		return employeeRepository.save(employee);
		}
	
	
	public Employee getEmployeeById(Long empId) {
		return employeeRepository.findById(empId).get();
	}

	
	public List<Employee> getEmployees() {
	    List<Employee> employees = employeeRepository.findAll();
	    
	    List<Employee> employeeList = new ArrayList<>();
		    for (Employee employee : employees) {
		        if (employee.getSalary() > 30000.0) {
		            employeeList.add(employee);
	        }
		    }
		   
		    Collections.sort(employeeList, Comparator.comparingDouble(Employee::getSalary));
		    return employeeList;
		}
	
	
	public void deleteEmployeeById(Long empId) {
		
		employeeRepository.deleteById(empId);
				
		}
		
	}
		
		
		
     
	
	
	
	
	
	


