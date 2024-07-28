package com.myBank.accountData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.myBank.common.InsufficientBalanceException;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/account")
public class AccountController 
{ 
	@Autowired
	AccountService accountService;
	
	@PostMapping("/operation")
	public ResponseEntity<Object> performOperation(@RequestParam String trnsType, @RequestParam String accountNo,  @RequestParam double amount) 
	{
		try {
			accountService.performOperation(trnsType, accountNo, amount);
			return ResponseEntity.ok("Operation Successful !!!");
			} 
		catch (InsufficientBalanceException e) 
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
		
	}
	
}
