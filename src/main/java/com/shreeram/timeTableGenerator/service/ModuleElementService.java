package com.shreeram.timeTableGenerator.service;
import java.util.*;

import com.shreeram.timeTableGenerator.entity.ModuleElement;

public interface ModuleElementService {

	
    List<ModuleElement> getModuleElement();

    ModuleElement addModuleElement(ModuleElement moduleElement);

    String deleteModuleElement(Long id);

    ModuleElement getModuleElementById(Long id);

    ModuleElement updateModuleElement(Long id, ModuleElement moduleElement);

    List<ModuleElement> getSchedulesByClass(Long classId);
}
