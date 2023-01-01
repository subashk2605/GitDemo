package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stg.entity.Orders;
import com.stg.entity.Restaurent;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Integer> {
	
	@Query(value = "select * from orders WHERE customer_id = :customerId " , nativeQuery = true)
	public abstract List<Orders> readMyOrders(@Param(value = "customerId") int customerId );
}
