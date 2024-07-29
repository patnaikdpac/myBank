package com.myBank.accountData;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myBank.common.InsufficientBalanceException;
import com.myBank.entity.AccountHistory;
import com.myBank.entity.AccountInfo;

import jakarta.transaction.Transactional;

@Repository
public class AccountRepository 
{
	
	@Autowired
	AccountInfoDao infoDao;
	
	@Autowired
	AccountHistoryDao historyDao;
	
	AccountHistory history = null;
	
	@Transactional
	public double withdraw(String accountNo, double amount) throws InsufficientBalanceException 
	{
		history = new AccountHistory();
		AccountInfo accountInfo = infoDao.findByAccountNo(accountNo);
		
		double remainingBal = 0.0;
		
		if(accountInfo.getBalance() < amount)
		{
			throw new InsufficientBalanceException("Insufficient Balance");
		}
		
		else
		{
			remainingBal = accountInfo.getBalance()-amount;
			accountInfo.setBalance(remainingBal);
		}
		
		history.setTrnsType("withdraw");
		history.setAmount(amount);
		//TO DO Check For account Number
		history.setAccountNo(accountNo);
		history.setTransDate(LocalDateTime.now());
		historyDao.save(history);
		//historyDao.setParam(accountNo, accountNo, amount, remainingBal);
		
		return accountInfo.getBalance();
	}

	@Transactional
	public double deposit(String accountNo, double amount) 
	{
		history = new AccountHistory();
		AccountInfo accountInfo = infoDao.findByAccountNo(accountNo);
		
		double newBal = accountInfo.getBalance()+ amount;
		accountInfo.setBalance(newBal);
		
		history.setTrnsType("deposit");
		history.setAmount(amount);
		history.setAccountNo(accountNo);
		
		history.setTransDate(LocalDateTime.now());
		historyDao.save(history);
		//historyDao.setParam(accountNo, accountNo, amount, newBal);
		return accountInfo.getBalance();	 
	}

	@Transactional
	public double checkBalance(String accountNo) 
	{
		AccountInfo accountInfo = infoDao.findByAccountNo(accountNo);
		
		return accountInfo.getBalance();
	}
	
	
	
}
