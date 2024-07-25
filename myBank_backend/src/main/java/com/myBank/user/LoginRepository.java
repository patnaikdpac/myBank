package com.myBank.user;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myBank.entity.User;

@Repository
public class LoginRepository {

    @Autowired
    UserDao dao;

    public Optional<User> userLogin(LoginUser loginUser) {
        Optional<User> user = dao.findByMailOrMobile(loginUser.getUserId(),loginUser.getUserId());
        if (user.isPresent() && user.get().getPassword().equals(loginUser.getPassword())) {
            return user;
        }
        return Optional.empty();
    }
}

