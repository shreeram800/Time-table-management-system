package com.shreeram.timeTableGenerator.repository;

import com.shreeram.timeTableGenerator.entity.Department;
import com.shreeram.timeTableGenerator.entity.Major;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.*;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	
	List<Department>  findDepartmentByLabel(String num);
    @Query("SELECT d FROM Department d WHERE d.label LIKE %?1%")

    Page<Department> searchWithPagination(String keyword, Pageable pageable);


    @Query("SELECT d.majors FROM Department d WHERE d.id = ?1")
    List<Major> getMajorsByDepartmentId(Long id);

}
