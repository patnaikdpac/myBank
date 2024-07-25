package com.myBank.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_info")
public class AccountInfo 
{
	@Id
	private Long id;
	
	@Column(name="account_no",length=12,unique=true)
	private String accountNo;
	
	private BigDecimal balance;
	
	@CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	@Column(name = "created_date")
	private LocalDateTime creDate;
	
	@CreatedBy
	@Column(name = "created_user")
	private String creUser;
}
