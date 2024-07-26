package com.myBank.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBank.accountData.AccountInfoDao;
import com.myBank.common.ApplicationKeys;
import com.myBank.common.EncryprDecrypt;
import com.myBank.entity.AccountInfo;
import com.myBank.entity.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	UserDao dao;
	
	@Autowired
	AccountInfoDao accountInfoDao;

	public User userRegistration(User user) {
		// TO DO Existing mail/mobile check before save
		EncryprDecrypt obj = null;
		try {
		obj = new EncryprDecrypt(ApplicationKeys.encKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		user.setPassword(obj.encrypt(user.getPassword()));
		dao.save(user);
		
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountNo(user.getAccountNo());
		accountInfo.setBalance(0.0);
		accountInfo.setCreUser("SYSTEM");
		accountInfoDao.save(accountInfo);
		user.setAccountInfo(accountInfo);
		return user;
	}

}