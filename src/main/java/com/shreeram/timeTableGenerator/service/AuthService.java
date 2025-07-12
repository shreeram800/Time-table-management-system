package com.shreeram.timeTableGenerator.service;

import com.shreeram.timeTableGenerator.dto.AuthResponse;

public interface AuthService {
    public AuthResponse login(String login, String password);
    public void logout(Long id);
	

}
