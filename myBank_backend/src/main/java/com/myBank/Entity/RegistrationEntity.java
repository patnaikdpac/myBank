package com.myBank.Entity;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name="Registration")
public class RegistrationEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
    
	@Id
	@Column(name="regd_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="first_name",length=20)
	private String firstName;
	@Column(name="last_name",length=20)
	private String lastName;
	
	@Column(length=50,unique=true)
	private String mail;
	
	@Column(name="mobile_no",length=12,unique=true)
	private String mobile;
	
	@Temporal(TemporalType.DATE)
	private Date dob;
	
	@Column(name="account_no",length=12,unique=true)
	private String accountNo;
	
	@Column(name="account_type",length=10)
	private String accountType;
	
	@Column(length=20)
	private String password;
	
}
