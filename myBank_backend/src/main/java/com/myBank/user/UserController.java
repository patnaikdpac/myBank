package com.myBank.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myBank.entity.User;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Transactional
@RequestMapping("/v1/user")
public class UserController {

	@Autowired
	LoginService loginService;
	
	@PostMapping("/registration")
	public User userRegistration(@RequestBody User user) {
		
		return user;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Object> userLogin(@RequestBody LoginUser loginUser) {
		
		return loginService.userLogin(loginUser);
	}
}
