package com.shreeram.timeTableGenerator.service.imp;

import java.util.List;

import com.shreeram.timeTableGenerator.entity.Teacher;
import com.shreeram.timeTableGenerator.repository.UserRepository;
import com.shreeram.timeTableGenerator.service.TeacherService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeacherServiceImp implements TeacherService {
	
	private final UserRepository userRepository;
	
	@Override
	public Teacher createTeacher(Teacher teacher) throws Exception {
		// TODO Auto-generated method stub
		return (Teacher) userRepository.save(teacher);
	}

	@Override
	public Teacher findTeacherById(Long teacherId) throws Exception {
		// TODO Auto-generated method stub
		return (Teacher) userRepository.findById(teacherId).orElseThrow(() -> new RuntimeException("User is not exist with " + teacherId + " this id"));
    }

	@Override
	public String deleteTeacher(long teacherId) {
		try {
			findTeacherById(teacherId);
            userRepository.deleteById(teacherId);
            return "Teacher deleted successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
	}

	@Override
	public Page<Teacher> getTeachers(Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.findUsersByRole("TEACHER", pageable);
	}

	@Override
	public Teacher updateTeacher(Teacher teacher, long teacherId) throws Exception {
		teacher.setId(teacherId);
		return (Teacher) userRepository.save(teacher);
	}

	@Override
	public Page<Teacher> searchTeachers(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return userRepository.searchWithPagination(keyword, pageable);
	}

	@Override
	public List<Teacher> getAllTeachers() {
		// TODO Auto-generated method stub
		return userRepository.findAllByRole("TEACHER");
	}

	@Override
	public List<Teacher> findTeacherByName(String name) {
		// TODO Auto-generated method stub
		return userRepository.findTeacherByName(name);
	}
	
}
