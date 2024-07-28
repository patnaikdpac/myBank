package com.myBank.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_info")
public class AccountInfo implements Serializable
{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "account_id")
	private Long ac_id;
	
	@Column(name="account_no",length=12,unique=true)
	private String accountNo;
	
	@Column(columnDefinition = "DECIMAL(10,2)")
	private double balance;
	
	@CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	@Column(name = "created_date")
	private LocalDateTime creDate;
	
	@CreatedBy
	@Column(name = "created_user")
	private String creUser;
	
	@LastModifiedBy
	private String modUser;
	
	@UpdateTimestamp
	@JsonFormat(pattern="dd/MM/yy hh:mm:ss a")
	@Column(name = "modified_date")
	private LocalDateTime modDate;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToMany(mappedBy = "accountInfo", cascade = CascadeType.ALL)
	private Set<AccountHistory> histories;
}
