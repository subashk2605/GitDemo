package com.stg.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id", nullable = false)
	private int addressId;

	@Column(name = "door_no", unique = true, length = 8, nullable = false)
	private String doorNo;

	@Column(name = "street", length = 25, nullable = false)
	private String street;

	@Column(name = "city", length = 25, nullable = false)
	private String city;

	@Column(name = "area", length = 25, nullable = false)
	private String area;

	@Column(name = "state", length = 25, nullable = false)
	private String State;
	
	@Column(name = "zipcode", length = 6, nullable = false)
	private int  zipCode;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonBackReference(value = "addresses_customer")
	private Customer customerRef;

}
