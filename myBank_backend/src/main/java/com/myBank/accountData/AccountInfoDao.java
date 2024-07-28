package com.myBank.accountData;


import org.springframework.data.repository.CrudRepository;

import com.myBank.entity.AccountInfo;

import jakarta.transaction.Transactional;

@Transactional
public interface AccountInfoDao extends CrudRepository<AccountInfo, Long> 
{

	AccountInfo findByAccountNo(String accountNo);

}
