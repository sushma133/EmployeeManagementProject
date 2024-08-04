package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.Employee;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		
	return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.createEmployee(employee));
	}
	
	
	@PutMapping("/employee")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		
	return ResponseEntity.status(HttpStatus.OK).body(employeeService.updateEmployee(employee));
	}
	
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long empId){
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployeeById(empId));
	}
	
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees(){
		
		return ResponseEntity.status(HttpStatus.OK).body(employeeService.getEmployees());
	}
	
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<String> deleteEmployeeById(@PathVariable Long empId) {
		employeeService.deleteEmployeeById(empId);
		return ResponseEntity.status(HttpStatus.OK).body("Employee Deleted successfully...!");
	}
}