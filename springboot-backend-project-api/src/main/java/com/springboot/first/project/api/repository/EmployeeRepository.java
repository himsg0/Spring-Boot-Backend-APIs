package com.springboot.first.project.api.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.springboot.first.project.api.model.Employee;
@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {

	
	
	
	// SELECT * FROM table WHERE name="" AND location=""
	List<Employee> findByNameAndLocation(String name, String location);
	
	// SELECT * FROM table WHERE name LIKE "%ram"
	List<Employee> findByNameContaining(String keyword, Sort sort);

	
}
