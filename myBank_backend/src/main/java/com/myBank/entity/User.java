package com.myBank.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "first_name", length = 20)
	private String firstName;

	@Column(name = "last_name", length = 20)
	private String lastName;

	@Column(length = 50, unique = true)
	private String mail;

	@Column(name = "mobile_no", length = 12, unique = true)
	private String mobile;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(name = "account_no", length = 12, unique = true)
	private String accountNo;

	@Column(name = "account_type", length = 10)
	private String accountType; // A or U

	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@Column(length = 500)
	private String password;

	@Column(name = "active_status")
	private int status;

	@CreatedBy
	private String creUser;

	@CreationTimestamp
	@JsonFormat(pattern = "dd/MM/yy hh:mm:ss a")
	private LocalDateTime creDate;

	@LastModifiedBy
	private String modUser;

	@UpdateTimestamp
	@JsonFormat(pattern = "dd/MM/yy hh:mm:ss a")
	private LocalDateTime modDate;

	
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private AccountInfo accountInfo;
	

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "address_id")
	private Address address;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "account_id")
	private AccountInfo accountinfo;

}
