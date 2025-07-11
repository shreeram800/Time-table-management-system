package com.shreeram.timeTableGenerator.service.imp;

import java.util.List;

import com.shreeram.timeTableGenerator.entity.Classes;
import com.shreeram.timeTableGenerator.entity.Major;
import com.shreeram.timeTableGenerator.repository.ClassesRepository;
import com.shreeram.timeTableGenerator.repository.MajorRepository;
import com.shreeram.timeTableGenerator.service.ClassesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassesServiceImp implements ClassesService {

	private final ClassesRepository lessonRepository;
	
	private final MajorRepository majorRepository;


	@Override
	public Classes createLesson(Classes lesson, long majorId) throws Exception {
		Major major = majorRepository.findById(majorId).orElseThrow(() -> new RuntimeException("Major is not exist"));
		lesson.setMajor(major);
		return lessonRepository.save(lesson);
	}

	@Override
	public Classes findLessonById(long lessonId) throws Exception {
		 return lessonRepository.findById(lessonId).orElseThrow(() -> new RuntimeException("Lesson is not exist"));
    }
	@Override
	public String deleteLesson(long lessonId) {
		try {
			findLessonById(lessonId);
            lessonRepository.deleteById(lessonId);
            return "Lesson deleted Successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
	}

	@Override
	public List<Classes> getAllLessons() {
		// TODO Auto-generated method stub
		return lessonRepository.findAll();
	}

	@Override
	public Classes updateLesson(long lessonId, Classes lesson) throws Exception {
		lesson.setId(lessonId);
		
		return lessonRepository.save(lesson);
	}

	@Override
	public Page<Classes> getLessons(Pageable pageable) {
		// TODO Auto-generated method stub
		return lessonRepository.findAll(pageable);
	}

	@Override
	public Page<Classes> searchLessons(String keyword, Pageable pageable) {
		// TODO Auto-generated method stub
		return lessonRepository.searchLessons(keyword, pageable);
	}

	@Override
	public Page<Classes> searchLessons(String keyword, Long sem, Pageable pageable) {
		// TODO Auto-generated method stub
		return lessonRepository.searchLessons(keyword, sem, pageable);
	}

	
}
