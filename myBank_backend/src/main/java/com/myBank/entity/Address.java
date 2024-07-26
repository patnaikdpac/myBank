package com.myBank.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String address_id;

	@Column(name = "house_no")
	private String houseNo;

	@Column(name = "street_name")
	private String streetName;

	@Column(name = "present_address")
	private String presentAddress;

	@Column(name = "permanent_address")
	private String permanentAddress;

	private String state;

	private String district;

	private String pincode;

	@Column(name = "user_id")
	private Long user_id;

}
