package com.shreeram.timeTableGenerator.controller;



import com.shreeram.timeTableGenerator.entity.Classes;
import com.shreeram.timeTableGenerator.service.ClassesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/classes")
@RequiredArgsConstructor
public class ClassesController {
	
	private final ClassesService classesService;
	
	
	   @GetMapping
	    public Page<Classes> getAllClasses(
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "20") int size
	    ) {
	        Pageable pageable = PageRequest.of(page, size);
	        return classesService.getLessons(pageable);
	    }

	    @GetMapping("/{id}")
	    public Classes getClassById(@PathVariable Long id) throws Exception {
	        return classesService.findLessonById(id);
	    }

	    @PostMapping
	    public Classes createClass(@RequestBody Classes lesson) throws Exception {
	        return classesService.createLesson(lesson, 1L);
	    }

	    @PutMapping("/{id}")
	    public Classes updateClass(@PathVariable Long id, @RequestBody Classes updatedClass) throws Exception {
	        return classesService.updateLesson(id, updatedClass);
	    }

	    @DeleteMapping("{id}")
	    public String deleteClass(@PathVariable Long id) {
	        return classesService.deleteLesson(id);
	    }

	    @GetMapping("/search")
	    public Page<Classes> searchClasses(
	            @RequestParam String keyword,
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size
	    ) {
	        Pageable pageable = PageRequest.of(page, size);
	        return classesService.searchLessons(keyword, pageable);
	    }

	    @GetMapping("/searchSem")
	    public Page<Classes> searchClassesSem(
	            @RequestParam String keyword,
	            @RequestParam(defaultValue = "0") int page,
	            @RequestParam(defaultValue = "10") int size,
	            @RequestParam Long sem
	    ) {
	        Pageable pageable = PageRequest.of(page, size);
	        return classesService.searchLessons(keyword,sem, pageable);
	    }
}
