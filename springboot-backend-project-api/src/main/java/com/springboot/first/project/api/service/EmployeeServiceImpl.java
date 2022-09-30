package com.springboot.first.project.api.service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.springboot.first.project.api.model.Employee;
import com.springboot.first.project.api.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository eRepository;
	
	
	
	@Override
	public Employee saveEmployee(Employee employee) {
		return eRepository.save(employee);
	}
	
	@Override
	public Employee getSingleEmployee(Long id) {
		Optional<Employee> employee =eRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		throw new RuntimeException("Employee is not found for the id"+id);
		
	}
	
	@Override
	public void deleteEmployee(Long id) {
		eRepository.deleteById(id);
	}
	
	@Override
	public Employee updateEmployee(Employee employee) {
		return eRepository.save(employee);
	}
	
	@Override
	public List<Employee>getEmployeesByNameAndLocation(String name , String location){
		return eRepository.findByNameAndLocation(name, location);
	}
	
	@Override
	public List<Employee>getEmployeesByKeyword(String name){
		Sort sort = Sort.by(Sort.Direction.DESC,"id");
		return eRepository.findByNameContaining(name, sort);
	}

	@Override
	public List<Employee> getEmployees(int pageNumber, int pageSize) {
	     org.springframework.data.domain.Pageable pages= PageRequest.of(pageNumber, pageSize);
		return eRepository.findAll(pages).getContent();
	}

	

	

	
	
}
