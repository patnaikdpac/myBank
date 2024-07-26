package com.myBank.accountData;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.myBank.entity.AccountInfo;

public interface AccountInfoDao extends CrudRepository<AccountInfo, Long> {

	Optional<AccountInfo> findByAccountNo(String accountNo);

}
