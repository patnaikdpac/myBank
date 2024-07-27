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
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "address_id")
	private Long address_id;

	@Column(name = "street", length = 100)
	private String street;

	@Column(name = "city", length = 50)
	private String city;

	@Column(name = "state", length = 50)
	private String state;

	@Column(name = "zip_code", length = 10)
	private String zipCode;

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
