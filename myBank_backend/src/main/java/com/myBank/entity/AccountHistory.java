package com.myBank.entity;

import java.time.LocalDateTime;


import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_history")
public class AccountHistory 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "transaction_id")
	private Long transId;
	
	
	@JoinColumn
	@Column(name="account_no",length=12,unique=true)
	private AccountInfo accountNo;
	
	@Column(name = "transaction_type", length = 12)
	private String trnsType;
	
	@Column(name = "transaction_amount", nullable = false )
	private double amount;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	@Column(name = "transaction_date")
	private LocalDateTime transDate;
	
	@Column(name = "current_balance")
	private double currBal;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account_id")
	private AccountInfo accountInfo;
}
