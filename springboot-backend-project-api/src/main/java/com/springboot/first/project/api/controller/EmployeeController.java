package com.springboot.first.project.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.project.api.model.Employee;
import com.springboot.first.project.api.service.EmployeeService;

import lombok.val;

@RestController
public class EmployeeController {
    
    
	@Autowired
	private EmployeeService eService;
	
	
	@GetMapping("/empl")
	public ResponseEntity<List<Employee>> getEmployees(@RequestParam Integer pageNumber, @RequestParam Integer pageSize){
		return new ResponseEntity<List<Employee>>( eService.getEmployees(pageNumber, pageSize),HttpStatus.OK);
	}
	
	@PostMapping("/employee")
	public Employee saveEmployees(@RequestBody Employee employee){
		return eService.saveEmployee(employee);
	}
	
	
	
	
	
	
	
	
	@GetMapping("/employee/{id}")
	public Employee getEmployee (@PathVariable Long id) {
		return eService.getSingleEmployee(id); 
	}
	
	@DeleteMapping("/employees")
	public void deleteEmployee (@RequestParam Long id) {
		eService.deleteEmployee(id);
	}
	
	@PutMapping("/employees/{id}")
	public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
		employee.setId(id);
		return eService.updateEmployee(employee);
	}
	
	@GetMapping("/employees/filterByNameAndLocation")
	public ResponseEntity<List<Employee>> getEmployeeByName(@RequestParam String name, @RequestParam String location){
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByNameAndLocation(name, location),HttpStatus.OK);
	}
	
	//sort by id
	@GetMapping("/employees/filterByKeyword")
	public ResponseEntity<List<Employee>> getEmployeeByKeyword(@RequestParam String name){
		return new ResponseEntity<List<Employee>>(eService.getEmployeesByKeyword(name),HttpStatus.OK);
	}
}
