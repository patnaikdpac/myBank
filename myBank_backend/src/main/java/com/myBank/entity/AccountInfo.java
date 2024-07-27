package com.myBank.entity;

import java.io.Serializable;
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
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "account_info")
public class AccountInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "account_info_id")
	private Long accountInfoId;

	@Column(name = "account_no", length = 12, unique = true)
	private String accountNo;

	private Double balance;

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
	@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
	private LocalDateTime modDate;

}
