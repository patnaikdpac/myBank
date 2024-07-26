package com.myBank.user;

import org.springframework.stereotype.Service;

import com.myBank.entity.User;

@Service
public interface RegistrationService {

	public User userRegistration(User user);
}
