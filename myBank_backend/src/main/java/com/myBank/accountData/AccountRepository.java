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
	
	AccountHistory history = new AccountHistory();
	
	@Transactional
	public double withdraw(String accountNo, double amount) throws InsufficientBalanceException 
	{
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
		
		history.setAccountInfo(accountInfo);
		history.setTrnsType("withdraw");
		history.setAmount(amount);
		history.setTransDate(LocalDateTime.now());
		historyDao.save(history);
		//historyDao.setParam(accountNo, accountNo, amount, remainingBal);
		
		return accountInfo.getBalance();
	}

	@Transactional
	public double deposit(String accountNo, double amount) 
	{
		AccountInfo accountInfo = infoDao.findByAccountNo(accountNo);
		
		double newBal = accountInfo.getBalance()+ amount;
		accountInfo.setBalance(newBal);
		
		history.setAccountInfo(accountInfo);
		history.setTrnsType("deposit");
		history.setAmount(amount);
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
