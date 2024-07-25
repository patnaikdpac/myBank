package com.myBank.user;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public interface LoginService {

	ResponseEntity<Object> userLogin(LoginUser loginUser);

}
