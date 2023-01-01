package com.stg.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class QuickFoods {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "quick_food_id", nullable = false)
	private int quickFoodId;

	// @Column(name = "userName",unique=true, nullable = false)
//	private String userName;
//	@Column(name = "password", nullable = false)
//	private String password;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "quickfoodRef")
	@JsonManagedReference(value = "customers_quickfood")
	private List<Customer> customers;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "quickfoodRef")
	@JsonManagedReference(value = "restaurent_quickfood")
	private List<Restaurent> restaurents;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "quickFoodsRef")
	@JsonManagedReference(value = "orders_quickfoods")
	private List<Orders> orders;

}
