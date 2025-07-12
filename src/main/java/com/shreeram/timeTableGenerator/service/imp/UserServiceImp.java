package com.shreeram.timeTableGenerator.service.imp;


import com.shreeram.timeTableGenerator.service.UserService;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
//	
//	private final UserRepository userRepository;
//	
//	@PostConstruct
//	public void createAdminAccount() {
//		User adminAccount = userRepository.findByRole("ADMIN");
//		
//		if(adminAccount == null) {
//			User admin = new User();
//			admin.setEmail("admin@admin.com");
//			admin.setPassword("admin");
//			admin.setFirstName("Admin");
//			admin.setRole("ADMIN");
//			userRepository.save(admin);
//		}
//
//		
//	}


}
