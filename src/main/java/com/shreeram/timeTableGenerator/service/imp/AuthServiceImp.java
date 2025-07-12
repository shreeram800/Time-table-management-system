package com.shreeram.timeTableGenerator.service.imp;

import com.shreeram.timeTableGenerator.dto.AuthResponse;
import com.shreeram.timeTableGenerator.entity.User;
import com.shreeram.timeTableGenerator.repository.UserRepository;
import com.shreeram.timeTableGenerator.service.AuthService;
import org.springframework.stereotype.Service;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImp implements AuthService {
	
	
	private final UserRepository userRepository;
	
	@Override
	public AuthResponse login(String login, String password) {
		User user = userRepository.findByLoginAndPassword(login, password);
		
		if(user != null) {
			user.setAuthenticated(true);
			userRepository.save(user);
			return new AuthResponse("token",user.getRole().equals("ADMIN"), user.getFirstName(),user.getId(),user.getRole().equals("TEACHER"),true);
        }
			
		return new AuthResponse();
		
	}
		

	@Override
	public void logout(Long id) {
        User user= userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
        user.setAuthenticated(false);
        userRepository.save(user);	
	}

//	private final UserRepository userRepository;
//	
//	private final PasswordEncoder passwordEncoder;
//	
//	private final AuthenticationManager authManager;
//	
//	private final JWTService jwtService;
//	
//	
//	@Override
//	public User signUp(SignUpRequest req) throws Exception {
//		Optional<User> isSnExist = userRepository.findBySchoolNumber(req.getSchoolNumber());
//		
//		if(isSnExist.isPresent()) {
//			throw new Exception("This school number is already exist");
//		}
//		if(req.getName() == null || req.getPassword()== null || req.getSchoolNumber()== null || req.getName() == "" || req.getPassword()== "" || req.getSchoolNumber()== "") {
//			throw new Exception("Fill in the all attributes !!");
//		}
//		
//		if(req.getSchoolNumber().length() != 10) {
//			throw new Exception("School number must be 10 digit");
//		}
//		
//		User user = new User();
//		
//		user.setSchoolNumber(req.getSchoolNumber());
//		user.setName(req.getName());
//		user.setRole(Role.USER);
//		user.setPassword(passwordEncoder.encode(req.getPassword()));
//		return userRepository.save(user);
//	}
//
//	@Override
//	public AuthResponse signIn(SignInRequest req) {
//		authManager.authenticate(new UsernamePasswordAuthenticationToken(req.getSchoolNumber(), req.getPassword()));
//		
//		var user = userRepository.findBySchoolNumber(req.getSchoolNumber()).orElseThrow(()-> new IllegalArgumentException("Invalid email or password"));
//		var token = jwtService.generateToken(user);
//		
//		AuthResponse res = new AuthResponse();
//		res.setToken(token);
//		
//		return res;
//	}

}
