package com.myBank.accountData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.myBank.common.InsufficientBalanceException;

@Service
public class AccountServiceImpl implements AccountService 
{

	
	@Autowired
	AccountRepository accountRepository;
	
	@Override
	public ResponseEntity<Object> performOperation(String trnsType, String accountNo, double amount) 
	{
		
		 switch (trnsType) 
		 { 
		 case "withdrawal": 
			 try 
			 {
				 double currentBal = accountRepository.withdraw(accountNo, amount);
                 return ResponseEntity.ok("Withdrawal successful. Remaining balance: " + currentBal);
			 }
		  
			 catch (InsufficientBalanceException e) 
			 {
			 	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
			 }
		 
		 case "deposit": 
		 	
		 	{
		 		double currentBal = accountRepository.deposit(accountNo, amount);
	            return ResponseEntity.ok("Deposit successful. New balance: " + currentBal);
		 	} 
		 	
		  
		  case "checkbalance":  
		  	{
		  		double currentBal = accountRepository.checkBalance(accountNo);
		  		return ResponseEntity.ok("Current balance: " + currentBal);
		  	}  
		  
		  default: 
			  return ResponseEntity.badRequest().body("Invalid operation") ;
		 
	
		 }
	}
}
		 
