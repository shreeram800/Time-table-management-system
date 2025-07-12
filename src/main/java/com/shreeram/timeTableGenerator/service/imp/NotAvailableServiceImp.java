package com.shreeram.timeTableGenerator.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.shreeram.timeTableGenerator.entity.NotAvailable;
import com.shreeram.timeTableGenerator.entity.Teacher;
import com.shreeram.timeTableGenerator.repository.NotAvailableRepository;
import com.shreeram.timeTableGenerator.service.NotAvailableService;
import com.shreeram.timeTableGenerator.service.TeacherService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NotAvailableServiceImp implements NotAvailableService {
	
	private final NotAvailableRepository notAvailableRepository;
	
	private final TeacherService teacherService;
	
	@Override
	public List<NotAvailable> getNotAvailables() {
		// TODO Auto-generated method stub
		return notAvailableRepository.findAll();
	}

	@Override
	public NotAvailable addNotAvailable(NotAvailable notAvailable) {
		// TODO Auto-generated method stub
		return notAvailableRepository.save(notAvailable);
	}

	@Override
	public String deleteNotAvailable(Long id) {
		try {
			getNotAvailableById(id);
			notAvailableRepository.deleteById(id);
            return "Deleted Successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
	}

	@Override
	public NotAvailable getNotAvailableById(Long id) {
		// TODO Auto-generated method stub
		 return notAvailableRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
	}

	@Override
	public NotAvailable updateNotAvailable(Long id, NotAvailable notAvailable) {
		notAvailable.setId(id);
        return notAvailableRepository.save(notAvailable);
	}

	@Override
	public List<NotAvailable> getNotAvailableByTeacherId(Long id) throws Exception {
		Teacher teacher = teacherService.findTeacherById(id);
		List<NotAvailable> notAvailables = new ArrayList<>();
		
		for(NotAvailable notAvailable : teacher.getNotAvailables()) {
			notAvailables.add(notAvailable);
		}
		return notAvailables;
	}

}
