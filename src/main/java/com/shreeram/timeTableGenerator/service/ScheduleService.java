package com.shreeram.timeTableGenerator.service;
import java.util.*;
import com.shreeram.timeTableGenerator.entity.ModuleElement;
import com.shreeram.timeTableGenerator.entity.Semester;


public interface ScheduleService {

    List<Map<Long, List<ModuleElement>>> getAllSchedules();
    List<ModuleElement> getSchedulesByClass(Long id);
    List<Map<Long, List<ModuleElement>>> generateSchedules();
    List<ModuleElement> getScheduleByTeacher(Long id) throws Exception;

    List<ModuleElement> getScheduleByTeacherAndSemester(long id, Semester semester);
}
