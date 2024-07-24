package com.myBank.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_history")
public class AccountHistory implements Serializable 
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="history_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long h_id;									//Sl.no. to keep track of number of updates to the account
	
	@Column(name="account_no",length=12,unique=true)
	private String accountNo;							//Unique account number 
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal withdrawlAmount;					//Amount of cash withdrawn
	
	@Column(name = "withdrawal_date")
	private LocalDateTime withdrawalDate;						//The date on which the withdrawal happened
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal depositAmount;					//Amount of cash deposited
	
	@Column(name = "deposit_date")
	private LocalDateTime depositDate;							//The date on which the deposit happened
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal currentBalance;					//Running balance of the user account

}
