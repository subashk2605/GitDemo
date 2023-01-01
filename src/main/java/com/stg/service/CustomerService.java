package com.stg.service;

import java.util.List;

import com.stg.entity.Address;
import com.stg.entity.Customer;
import com.stg.entity.Food;
import com.stg.entity.Orders;
import com.stg.entity.Payment;
import com.stg.entity.Restaurent;
import com.stg.exception.CustomException;

public interface CustomerService {
	
	public abstract String createCustomer(Customer customer) throws CustomException;

	public abstract String addCustomer(int customerId,String customerName , String customerPhNo , String email , String password ,String doorNo ,String street,String city ,String area , String state , int zipcode ) throws CustomException;

	public abstract String createAddress(int customerId,  int  addressId ,String doorNo,
			String street, String city, String area, String state, int zipcode) throws CustomException;

	public abstract List<Food> readfoodMenu() throws CustomException;

//	public abstract Orders placeOrders(String foodname, int quantity, int customerId, String payment) throws CustomException;

	public abstract String cancelOrder(int customerId, int orderId) throws CustomException;

	public abstract List<Orders> readMyOrders(int customerId) throws CustomException;

	public abstract List<Food> readFoodByCatogory(String catogory) throws CustomException;

	public abstract List<Food> readFoodByName(String name) throws CustomException;

	public abstract List<Food> readByVegOrNonveg(String name) throws CustomException;

	public abstract  List<Restaurent> readall() throws CustomException;
	
	public abstract  List<Food> readfoodByRestaurent(int restaurentId) throws CustomException;
	
	public abstract Orders placeOrders(int foodId , int quantity ,int customerId , String payment) throws CustomException;
	
	
	
	
}
