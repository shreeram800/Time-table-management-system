package com.shreeram.timeTableGenerator.service;

import java.util.List;

import com.shreeram.timeTableGenerator.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.shreeram.timeTableGenerator.entity.Major;

public interface DepartmentService {

	
	List<Department> getDepartments();
	
	Department createDepartment(Department department);
	
	List<Department> findDepartmentByName(String name);
	
	String deleteDepartment(long id);
	
	Department getDepartmentById(long id);
	
	Department updateDepartment(long id, Department department);
	
	Page<Department> searchDepartments(String keyword,Pageable pageable);
	
	List<Major> getMajorByDepartmentId(long id);
	
}
