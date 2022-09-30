package com.springboot.first.project.api.model;



import java.sql.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.PackagePrivate;


@Getter
@Setter
@ToString
@Entity
@Table(name="tbl_employee")


public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="age")
	private Long age;
	
	@Column(name="location")
	private String location;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDate() {
		return creatAt;
	}
	public void setDate(Date creatAt) {
		this.creatAt = creatAt;
	}
	
	public Date getUpdateDate() {
		return upateAtDate;
	}
	public void setUpdateDate(Date creatAt) {
		this.upateAtDate = upateAtDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Column(name="email")
	private String email;
	
	@Column(name="department")
	private String department;
	
	@CreationTimestamp
	@Column(name="created_at",nullable = false,updatable = false)
	private Date creatAt;
	
	@UpdateTimestamp
	@Column(name="updated_at")
	private Date upateAtDate;
}
