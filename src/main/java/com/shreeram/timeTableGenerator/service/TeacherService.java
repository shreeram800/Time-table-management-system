package com.shreeram.timeTableGenerator.service;

import java.util.List;

import com.shreeram.timeTableGenerator.entity.Teacher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TeacherService {
	
	 Teacher createTeacher(Teacher teacher)throws Exception ;
	 
	 Teacher findTeacherById(Long teacherId) throws Exception;
	 
	 public String deleteTeacher(long teacherId);
	 
	 public Page<Teacher> getTeachers(Pageable pageable);
	 
	 public Teacher updateTeacher(Teacher teacher,long teacherId) throws Exception;
	 
	 Page<Teacher> searchTeachers(String keyword,Pageable pageable);
	 
	 List<Teacher> getAllTeachers();
	 
	 List<Teacher> findTeacherByName(String name);

}
