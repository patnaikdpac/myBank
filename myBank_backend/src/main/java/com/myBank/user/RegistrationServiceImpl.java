package com.myBank.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myBank.accountData.AccountInfoDao;
import com.myBank.accountData.AddressDao;
import com.myBank.common.ApplicationKeys;
import com.myBank.common.EncryprDecrypt;
import com.myBank.common.GenerateAccountNumber;
import com.myBank.entity.AccountInfo;
import com.myBank.entity.Address;
import com.myBank.entity.User;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	UserDao dao;

	@Autowired
	AccountInfoDao accountInfoDao;
	
	@Autowired
	AddressDao addressDao;


	public User userRegistration(User user) 
	{
		// TO DO Existing mail/mobile check before save

	public User userRegistration(User user) {
		if (dao.existsByMail(user.getMail()) || dao.existsByMobile(user.getMobile())) {
			throw new IllegalArgumentException("Email or Mobile already exists");
		}

		EncryprDecrypt obj = null;
		try {
			obj = new EncryprDecrypt(ApplicationKeys.encKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		user.setAccountNo(GenerateAccountNumber.generateAccountNumber());
		user.setPassword(obj.encrypt(user.getPassword()));
		dao.save(user);

		
		AccountInfo accountInfo = new AccountInfo();
		accountInfo.setAccountNo(user.getAccountNo());
		accountInfo.setBalance(0.0);
		accountInfo.setCreUser("SYSTEM");
		accountInfoDao.save(accountInfo);
		//user.setAccountInfo(accountInfo);

		if (user != null) {
			AccountInfo accountInfo = new AccountInfo();
			accountInfo.setAccountInfoId(user.getId());
			accountInfo.setAccountNo(user.getAccountNo());
			accountInfo.setBalance(0.0);
			accountInfo.setCreUser(user.getMail());
			accountInfoDao.save(accountInfo);
			//user.setAccountinfo(accountInfo);
			Address address = new Address();
			address.setAddress_id(user.getId());
			address.setCreUser(user.getMail());
			address.setModUser(user.getMail());
			addressDao.save(address);
			//user.setAddress(address);
		}

		return user;
	}

}