package com.shreeram.timeTableGenerator.repository;

import com.shreeram.timeTableGenerator.entity.Major;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MajorRepository extends JpaRepository<Major, Long>{

	@Query("SELECT m FROM Major m WHERE m.label LIKE %?1% ")
	Page<Major> searchMajors(String keyword,Pageable pageable);
}
