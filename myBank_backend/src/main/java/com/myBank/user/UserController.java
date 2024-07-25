package com.myBank.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myBank.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/user")
public class UserController 
{
	
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/registration")
	public User userRegistration(@RequestBody User user) 
	{
		
		return registrationService.userRegistration(user);
	}
	
	@PostMapping("/login")
	public String userLogin(@RequestBody LoginUser loginUser) 
	{
		
		return null;
	}
}
