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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurent_id", unique = true, nullable = false)
	private int restaurentId;

	@Column(name = "restaurent_no", unique = true, nullable = false)
	private String restaurentNo;

	@Column(name = "restaurent_name", length = 25, nullable = false)
	private String restaurentName;

	@Column(name = "restaurent_email", length = 25, nullable = false)
	private String restaurentEmail;
	
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "restaurent_phoneno", unique = true, length = 10, nullable = false)
	private String restaurentPhoneNo;

	@Column(name = "restaurent_street", length = 25, nullable = false)
	private String restaurentStreet;

	@Column(name = "area", length = 25, nullable = false)
	private String area;

	@Column(name = "restaurent_city", length = 25, nullable = false)
	private String restaurentCity;

	@Column(name = "restaurent_state", length = 25, nullable = false)
	private String restaurentState;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "restaurentRef")
	@JsonManagedReference(value = "food_restaurent")
	private List<Food> foods;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quick_food_id", nullable = true)
	@JsonBackReference(value = "restaurent_quickfood")
	private QuickFoods quickfoodRef;

}
