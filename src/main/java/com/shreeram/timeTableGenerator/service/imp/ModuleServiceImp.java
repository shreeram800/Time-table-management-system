package com.shreeram.timeTableGenerator.service.imp;

import java.util.List;

import com.shreeram.timeTableGenerator.entity.Module;
import com.shreeram.timeTableGenerator.repository.ModuleRepository;
import com.shreeram.timeTableGenerator.service.ModuleService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ModuleServiceImp implements ModuleService {
	
	private final ModuleRepository moduleRepository;
	
	@Override
	public List<Module> getModules() {
		// TODO Auto-generated method stub
		return moduleRepository.findAll();
	}

	@Override
	public Module addModule(Module module) {
		// TODO Auto-generated method stub
		return moduleRepository.save(module);
	}

	@Override
	public String deleteModule(Long id) {
		try {
            getModuleById(id);
            moduleRepository.deleteById(id);
            return "Module deleted successfully";
        } catch (Exception e) {
            return e.getMessage();
        }
	}

	@Override
	public Module getModuleById(Long id) {
		// TODO Auto-generated method stub
		return moduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Module not found"));
	}

	@Override
	public Module updateModule(Long id, Module module) {
		// TODO Auto-generated method stub
		module.setId(id);
		return moduleRepository.save(module);
	}

}
