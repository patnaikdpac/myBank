package com.myBank.user;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myBank.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginRepository loginRepository;

    private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Override
    public ResponseEntity<Object> userLogin(LoginUser loginUser) {
        Map<String, Object> response = new LinkedHashMap<>();
        HttpStatus status;

        try {
            Optional<User> user = loginRepository.userLogin(loginUser);

            if (user.isPresent()) {
                status = HttpStatus.OK;
                response.put("status", "OK");
                response.put("message", "Login Successful");
                response.put("user", user.get());
            } else {
                status = HttpStatus.NOT_FOUND;
                response.put("status", "ERROR");
                response.put("message", "User not found");
            }
        } catch (DataAccessException dae) {
            logger.error("Database error occurred during login", dae);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.put("status", "ERROR");
            response.put("message", "Database error occurred during login");
        } catch (Exception e) {
            logger.error("An unexpected error occurred during login", e);
            status = HttpStatus.INTERNAL_SERVER_ERROR;
            response.put("status", "ERROR");
            response.put("message", "An unexpected error occurred during login");
        }

        return new ResponseEntity<>(response, status);
    }
}
