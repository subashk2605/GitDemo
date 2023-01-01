package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stg.entity.Customer;
import com.stg.entity.Food;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>  {
	
	public abstract Customer findByCustomerName(String customerName);
	
	@Query (value = "SELECT * FROM food WHERE food_catogory = : food ;" ,nativeQuery = true)
	public abstract List<Food> readFoodByCatogory(@Param(value = "food") Food food );

}
