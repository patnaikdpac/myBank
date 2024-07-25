package com.myBank.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_history")
public class AccountHistory 
{
	@Id
	@Column(name = "history_id")
	private Long h_id;
	
	@Column(name="account_no",length=12,unique=true)
	private String accountNo;
	
	
	@Column(name = "withdrawal_amount", nullable = false )
	private BigDecimal withdrawAmt;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	@Column(name = "withdraw_date")
	private LocalDateTime withdrawDate;
	
	@Column(name = "deposit_amount", nullable = false )
	private BigDecimal depositAmt;
	
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	@Column(name = "deposit_date")
	private LocalDateTime depoDate;
	
	@Column(name = "current_balance")
	private BigDecimal currBal;
}
