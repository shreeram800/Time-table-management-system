package com.shreeram.timeTableGenerator.repository;

import java.util.List;

import com.shreeram.timeTableGenerator.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SemesterRepository extends JpaRepository<Semester, Long> {
	
	List<Semester> findByNumber(Semester number);

}
