package com.myBank.accountData;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myBank.common.InsufficientBalanceException;

@Service
public interface AccountService 
{

	ResponseEntity<Object> performOperation(String trnsType, String accountNo, double amount) throws InsufficientBalanceException;

}
