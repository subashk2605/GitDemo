package com.stg.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.stg.entity.Customer;
import com.stg.entity.Food;
import com.stg.entity.Orders;
import com.stg.entity.Restaurent;
import com.stg.exception.CustomException;


public interface QuickFoodsService {
	
	
	public abstract List<Customer> readAll() throws CustomException;
	
	public abstract Customer findByCustomerId(int customerId) throws CustomException;
	
	public abstract Customer findByCustomerName(String customerName) throws CustomException;
	
	public abstract String createCustomer(Customer customer)  throws CustomException;
	
	public abstract String deleteByCustomerId(int  customerId)  throws CustomException;

	public abstract String deleteByCustomerName(String  customerName)  throws CustomException;
	
	public abstract String updateByCustomerId(Customer  customer , int customerId)  throws CustomException;
	
	
	
	

	
	
	public abstract  List<Restaurent> readall() throws CustomException;

	public abstract Restaurent findByRestaurentId(int restaurentId) throws CustomException;
	
	public abstract Restaurent findByRestaurentName(String restaurentName) throws CustomException;
	
	public abstract String createRestaurent(Restaurent restaurent)  throws CustomException;
	
	public abstract String deleteByRestaurentId(int  restaurentId)  throws CustomException;

	public abstract String deleteByRestaurentName(String  restaurentName)  throws CustomException;
	
	public abstract String updateByRestaurentId(Restaurent  restaurent , int restaurentId)  throws CustomException;
	
	
	public abstract List<Orders> readMyOrders( int customerId ) throws CustomException;
	
	

}
