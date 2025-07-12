package com.shreeram.timeTableGenerator.service;

import java.util.List;

import com.shreeram.timeTableGenerator.entity.Semester;
import com.shreeram.timeTableGenerator.entity.enums.SemesterNumber;



public interface SemesterService {
	
	List<Semester> getSemesters();
	
	Semester addSemster(Semester semster);
	
	String deleteSemester(long id);
	
	Semester getSemesterById(long id);
	
	Semester updateSemester(long id, Semester semster);
	
	List<Semester> findSemesterByNum(SemesterNumber num);

}
