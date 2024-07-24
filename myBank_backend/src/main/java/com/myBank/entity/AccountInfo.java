package com.myBank.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_info")
public class AccountInfo implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="regd_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;									//primary key and should be linked with the user table
	
	@Column(name="account_no",length=12,unique=true)
	private String accountNo;							//Unique account number 
	
	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal balance;							//Store the current balance of the user
	
	@CreatedBy
	private String creUser;								//firstname and lastname from the user table, the user who had created the account
	
	@CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a") 
	private LocalDateTime creDate;						// The date on which the account was first created by the user 
	
	@LastModifiedBy
	private String modUser;								//The user who has last updated; can be the original user or the admin
	
	@UpdateTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private LocalDateTime modDate;						//The date on which the account balance was last updated
}
