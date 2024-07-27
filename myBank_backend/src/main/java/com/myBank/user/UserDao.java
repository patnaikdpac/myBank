package com.myBank.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.myBank.entity.User;

public interface UserDao extends CrudRepository<User, Long>
{
	   Optional<User> findByMailOrMobile(String mail, String mobile);
	   boolean existsByMail(String mail);
	    boolean existsByMobile(String mobile);

}

