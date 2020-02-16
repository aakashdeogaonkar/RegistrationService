package com.RegistrationService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.RegistrationService.model.User;
import com.RegistrationService.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User register(User user) {
		return userRepository.save(user);
	}
	
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	
	public List<User> findUser(String email) {
		return userRepository.findByEmail(email);
	}
	
	public List<User> cancelRegistration(int id) {
		userRepository.deleteById(id);
		return userRepository.findAll();
	}
}
