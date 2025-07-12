package com.shreeram.timeTableGenerator.service.imp;

import java.util.List;

import com.shreeram.timeTableGenerator.entity.Semester;
import com.shreeram.timeTableGenerator.entity.enums.SemesterNumber;
import com.shreeram.timeTableGenerator.repository.SemesterRepository;
import com.shreeram.timeTableGenerator.service.SemesterService;
import org.springframework.stereotype.Service;



import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SemesterServiceImp implements SemesterService {
	
	private final SemesterRepository semesterRepository;
	
	@Override
	public List<Semester> getSemesters() {
		// TODO Auto-generated method stub
		return semesterRepository.findAll();
	}

	@Override
	public Semester addSemster(Semester semster) {
		// TODO Auto-generated method stub
		return semesterRepository.save(semster);
	}

	@Override
	public String deleteSemester(long id) {
		try {
			getSemesterById(id);
			semesterRepository.deleteById(id);
			return "Deleted succesfully";
		}catch(Exception e) {
			return e.getMessage();
		}
		
	}

	@Override
	public Semester getSemesterById(long id) {
		return semesterRepository.findById(id).orElseThrow(() -> new RuntimeException("This semester is not exist"));
	}

	@Override
	public Semester updateSemester(long id, Semester semster) {
		semster.setId(id);
		
		return semesterRepository.save(semster);
	}

	@Override
	public List<Semester> findSemesterByNum(SemesterNumber num) {
		return null;
	}

}
