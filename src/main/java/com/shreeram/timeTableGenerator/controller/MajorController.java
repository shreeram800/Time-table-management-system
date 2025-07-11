package com.shreeram.timeTableGenerator.controller;

import com.shreeram.timeTableGenerator.entity.Major;
import com.shreeram.timeTableGenerator.entity.Semester;
import com.shreeram.timeTableGenerator.service.MajorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/majors")
@RequiredArgsConstructor
public class MajorController {
	
	private final MajorService majorService;
	
	
    @GetMapping
    public Page<Major> getAllMajors(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return majorService.getMajors(pageable);
    }
    
    @GetMapping("/all")
    public List<Major> getAllMajors(){
    	return majorService.getAllMajors();
    }

    @GetMapping("/{id}")
    public Major getMajorById(@PathVariable Long id) {
        return majorService.getMajorById(id);
    }

    @PostMapping
    public Major createMajor(@RequestBody Major major) {
        return majorService.createMajor(major);
    }

    @PutMapping("/{id}")
    public Major updateMajor(@PathVariable Long id, @RequestBody Major updatedMajor) {
        return majorService.updateMajor(id, updatedMajor);
    }

    @DeleteMapping("/{id}")
    public String deleteMajor(@PathVariable Long id) {
        return majorService.deleteMajor(id);
    }

    @GetMapping("/search")
    public Page<Major> searchMajors(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return majorService.searchMajors(keyword, pageable);
    }

    @GetMapping("/{id}/semesters")
    public List<Semester> getSemestersByMajors(@PathVariable Long id) {
        return majorService.getSemesterByMajor(id);
    }
}

