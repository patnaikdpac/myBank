package com.myBank.user;

import org.springframework.data.repository.CrudRepository;
import com.myBank.entity.User;

public interface UserDao extends CrudRepository<User, Long>
{
	

}
