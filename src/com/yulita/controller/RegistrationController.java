package com.yulita.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yulitandria.entity.User;
import com.yulitandria.service.UserServiceImpl;

@RestController
public class RegistrationController {

	private UserServiceImpl userService;

    @PostMapping(name="/registration")
    public User registerUser(@RequestParam(value="firstName") String firstName, @RequestParam(value="lastName") String lastName,
    		@RequestParam(value="phone") String phone, @RequestParam(value="dob") String dob, @RequestParam(value="email") String email,@RequestParam(value="gender") String gender) throws Exception {
        User user = null;
        
        user = userService.getUserByPhoneNumber(phone);
        if(user!=null) {
        	throw new Exception("No duplicate phone number");
        }
        
        user = userService.getUserByEmail(email);
        if(user!=null) {
        	throw new Exception("No duplicate email");
        }
    	
        user = new User(firstName, lastName, email, phone, dob, gender);
        userService.saveUser(user);
        
    	return user;
    }
}
