package com.myBank.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myBank.entity.User;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/v1/user")
public class UserController {

	@PostMapping("/registration")
	public User userRegistration(@RequestBody User user) {
		
		return user;
	}
	
	@PostMapping("/login")
	public String userLogin(@RequestBody LoginUser loginUser) {
		
		return null;
	}
}
