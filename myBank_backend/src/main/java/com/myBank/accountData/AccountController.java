package com.myBank.accountData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/account")
public class AccountController 
{
	@Autowired
	AccountService accountService;
	
	@PostMapping("/operation")
	public ResponseEntity<Object> performOperation(@RequestParam String accountNo, @RequestParam String opType, @RequestParam Double amount) 
	{
		return null;
		
		/*
		 * switch (opType) { case "withdrawal": try {
		 * 
		 * } catch (Exception e) { }
		 * 
		 * switch (opType) { case "deposit": try {
		 * 
		 * } catch (Exception e) { }
		 * 
		 * switch (opType) { case "checkbalance": try {
		 * 
		 * } catch (Exception e) { } default: throw new
		 * IllegalArgumentException("Unexpected value: " + key); } return
		 * ResponseEntity<Object> ;
		 */
	}
	
}
