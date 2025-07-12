package com.shreeram.timeTableGenerator.service.imp;

import java.util.List;

import com.shreeram.timeTableGenerator.entity.Classroom;
import com.shreeram.timeTableGenerator.repository.ClassroomRepository;
import com.shreeram.timeTableGenerator.service.ClassroomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassroomServiceImp implements ClassroomService {
	
	private final ClassroomRepository classroomRepository;

	@Override
	public Classroom createClassroom(Classroom classroom) {
		// TODO Auto-generated method stub
		return classroomRepository.save(classroom);
	}

	@Override
	public Classroom findClassromById(long id) throws Exception {
		   return classroomRepository.findById(id).orElseThrow(() -> new RuntimeException("Classroom is not exist!"));
    }


	@Override
	public String deleteClassroom(Long id) {
		try {
			findClassromById(id);
			classroomRepository.deleteById(id);
            return "Classroom deleted successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
	}

	@Override
	public Classroom updateClassroom(Classroom classroom, long classroomId) {
		classroom.setId(classroomId);
		
		
		return classroomRepository.save(classroom);
	}

	@Override
	public List<Classroom> findAllClassrooms() {
		// TODO Auto-generated method stub
		return classroomRepository.findAll();
	}

	@Override
	public Page<Classroom> searchClassrooms(int keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return classroomRepository.searchWithPagination(keyword, pageable);
	}

	@Override
	public Page<Classroom> getClassrooms(Pageable pageable) {
		// TODO Auto-generated method stub
		return classroomRepository.findAll(pageable);
	}
	


}
