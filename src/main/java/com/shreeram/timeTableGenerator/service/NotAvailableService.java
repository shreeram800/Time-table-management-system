package com.shreeram.timeTableGenerator.service;

import java.util.List;

import com.shreeram.timeTableGenerator.entity.NotAvailable;

public interface NotAvailableService {

	
	List<NotAvailable> getNotAvailables();
	
	NotAvailable addNotAvailable(NotAvailable notAvailable);
	
	String deleteNotAvailable(Long id);
	
	NotAvailable getNotAvailableById(Long id);
	
	NotAvailable updateNotAvailable(Long id, NotAvailable notAvailable);
	
	List<NotAvailable> getNotAvailableByTeacherId(Long id) throws Exception;
}
