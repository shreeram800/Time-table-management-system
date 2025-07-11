package com.shreeram.timeTableGenerator.service.imp;

import java.util.List;

import com.shreeram.timeTableGenerator.entity.Department;
import com.shreeram.timeTableGenerator.entity.Major;
import com.shreeram.timeTableGenerator.repository.DepartmentRepository;
import com.shreeram.timeTableGenerator.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImp implements DepartmentService {
	
	private final DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getDepartments() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	@Override
	public Department createDepartment(Department department) {
		// TODO Auto-generated method stub
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> findDepartmentByName(String name) {
		// TODO Auto-generated method stub
		return departmentRepository.findDepartmentByLabel(name);
	}

	@Override
	public String deleteDepartment(long id) {
		 try {
			 getDepartmentById(id);
			 departmentRepository.deleteById(id);
	            return "Department Deleted Successfully";
	        } catch (Exception e) {
	            return e.getMessage();
	        }
	}

	@Override
	public Department getDepartmentById(long id) {
		return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department is not exist"));
	}

	@Override
	public Department updateDepartment(long id, Department department) {
		department.setId(id);
		return departmentRepository.save(department);
	}

	@Override
	public Page<Department> searchDepartments(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return departmentRepository.searchWithPagination(keyword, pageable);
	}

	@Override
	public List<Major> getMajorByDepartmentId(long id) {
		// TODO Auto-generated method stub
		return departmentRepository.getMajorsByDepartmentId(id);
	}

}
