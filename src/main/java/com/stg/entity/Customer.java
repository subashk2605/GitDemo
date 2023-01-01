package com.stg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "customer_id", unique = true, nullable = false)
	private int customerId;
	@Column(name = "customer_name", length = 25, nullable = false)
	private String customerName;
	@Column(name = "customer_email", length = 30, nullable = false)
	private String eMail;
	@Column(name = "password", nullable = false)
	private String password;
	@Column(name = "phone_no", unique = true, length = 10, nullable = false)
	private String phoneNo;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerRef")
	@JsonManagedReference(value = "addresses_customer")
	private List<Address> addresses;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quick_food_id", nullable = true)
	@JsonBackReference(value = "customers_quickfood")
	private QuickFoods quickfoodRef;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "customerRef")
	@JsonManagedReference(value = "order_customer")
	private List<Orders> orders;

}
