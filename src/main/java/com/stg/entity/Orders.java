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
import com.stg.dto.FoodDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private int orderId;
//	@Column(name = "foodname", nullable = false)
//	private String foodName;

	@Column(name = "quantity", nullable = false)
	private int Quantity;

	@Column(name = "price", nullable = false)
	private float price;

	@Column(name = "orderStatus", nullable = false)
	private String orderStatus;

	@Column(name = "payment_Status", nullable = false)
	private String paymentStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	@JsonBackReference(value = "order_customer")
	private Customer customerRef;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orders")
	@JsonManagedReference(value = "orders_food")
	private List<Food> foods;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "quick_food_id", nullable = true)
	@JsonBackReference(value = "orders_quickfoods")
	private QuickFoods quickFoodsRef;

}
