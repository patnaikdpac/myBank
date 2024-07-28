package com.myBank.accountData;

import org.springframework.data.repository.CrudRepository;

import com.myBank.entity.AccountHistory;

public interface AccountHistoryDao extends CrudRepository<AccountHistory, Long> 
{

	//AccountHistory setParam(String accountNo, String transType, double amount, double currentBal);
	
}
