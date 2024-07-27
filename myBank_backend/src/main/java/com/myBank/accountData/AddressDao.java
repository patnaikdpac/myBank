package com.myBank.accountData;

import org.springframework.data.repository.CrudRepository;


import com.myBank.entity.Address;

public interface AddressDao extends CrudRepository<Address, Long>{

}
