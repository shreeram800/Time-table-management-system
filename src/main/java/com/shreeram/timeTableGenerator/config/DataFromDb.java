package com.shreeram.timeTableGenerator.config;
import java.util.List;

import com.shreeram.timeTableGenerator.entity.*;
import com.shreeram.timeTableGenerator.entity.Module;
import com.shreeram.timeTableGenerator.service.*;
import org.springframework.stereotype.Component;


import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataFromDb {
	
	public static List<Classroom> classrooms;
	public static List<Classes> lessons;
	public static List<Teacher> teachers;
	public static List<Semester> semesters;
	public static List<Module> modules;
	public static List<ModuleElement> moduleElements;
	public static List<Major> majors;
	public static List<Department> departments;
	
	private ClassroomService classroomService;
	private ClassesService lessonService;
	private TeacherService teacherService;
	private SemesterService semesterService;
	private ModuleService moduleService;
	private ModuleElementService moduleElementService;
	private MajorService majorService;
	private DepartmentService departmentService;

	
	
	public void loadDataFromDatabase() {
		classrooms = classroomService.findAllClassrooms();
		lessons = lessonService.getAllLessons();
		teachers = teacherService.getAllTeachers();
		modules = moduleService.getModules();
		moduleElements = moduleElementService.getModuleElement();
		semesters = semesterService.getSemesters();
		majors = majorService.getAllMajors();
		departments = departmentService.getDepartments();
	
	}
}
