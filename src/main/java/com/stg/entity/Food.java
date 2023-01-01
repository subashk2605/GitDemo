package com.stg.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;

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
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "foodId", length = 25, nullable = false)
	private int foodId;

	@Column(name = "food_catogory", length = 25, nullable = false)
	private String foodCatogory;

	@Column(name = "veg_nonveg", length = 25, nullable = false)
	private String vegOrNonveg;

	@Column(name = "food_name", length = 25, nullable = false)
	private String foodName;

	@Column(name = "food_price", length = 10, nullable = false)
	private float foodPrice;

	@Column(name = "quantity", nullable = false)
	private int quantity;	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurent_id", nullable = false)
	@JsonBackReference(value = "food_restaurent")
	private Restaurent restaurentRef;

	@ManyToOne(fetch = FetchType.LAZY)
	@JsonBackReference(value = "orders_food")
	private Orders orders;
	
	

}
