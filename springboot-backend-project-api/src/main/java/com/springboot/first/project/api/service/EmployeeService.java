package com.springboot.first.project.api.service;

import java.util.List;
import java.util.function.LongFunction;

import com.springboot.first.project.api.model.Employee;

public interface EmployeeService {

	List<Employee> getEmployees(int pageNumber , int pageSize);
	
	Employee saveEmployee(Employee employee);
	
	Employee getSingleEmployee(Long id );
	
	void deleteEmployee (Long id);
	
	Employee updateEmployee(Employee employee);
	
	List<Employee> getEmployeesByNameAndLocation(String name , String location);
	
	List<Employee> getEmployeesByKeyword(String name);
}
