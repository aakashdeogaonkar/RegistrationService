package com.RegistrationService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.RegistrationService.model.User;
import com.RegistrationService.service.UserService;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/register")
    public String register(@RequestBody User user) {
		userService.register(user);
        return "Hi " + user.getName() + " your Registration process successfully completed";
    }
	
	@GetMapping("/getAllUsers")
    public List<User> findAllUsers() {
        return userService.findAllUser();
    }
	
	@GetMapping("/findUser/{email}")
    public List<User> findUser(@PathVariable String email) {
        return userService.findUser(email);
    }
	
	@DeleteMapping("/cancel/{id}")
    public List<User> cancelRegistration(@PathVariable int id) {
		userService.cancelRegistration(id);
        return userService.findAllUser();
    }
}
