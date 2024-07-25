package com.myBank.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBank.entity.User;

@Service
public class RegistrationServiceImpl implements RegistrationService
{
	@Autowired
	UserDao dao;
	
	public User userRegistration(User user)
	{
		return dao.save(user);
	}
	
}