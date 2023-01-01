package com.stg.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stg.entity.Customer;
import com.stg.entity.Food;
import com.stg.entity.Orders;
import com.stg.entity.Restaurent;
import com.stg.exception.CustomException;
import com.stg.repository.CustomerRepository;
import com.stg.repository.FoodRepository;
import com.stg.repository.QuickFoodsRepository;
import com.stg.repository.RestaurentRepository;
@Service
public class QuickFoodsServiceImpl implements  QuickFoodsService {

	@Autowired private CustomerRepository customerRepository;
	@Autowired private RestaurentRepository restaurentRepository;
	@Autowired private QuickFoodsRepository repository;
	@Autowired private FoodRepository foodRepository;
	@Autowired private CustomerServiceImpl customerServiceImpl;
	
	@Override
	public List<Customer> readAll() throws CustomException {

		if (customerRepository.findAll() == null) {
			throw new CustomException("No record found");
		} else {
			return customerRepository.findAll();
		}
	}

	@Override
	public Customer findByCustomerId(int customerId) throws CustomException {

		Optional<Customer> optional = customerRepository.findById(customerId);
		if (!optional.isPresent()) {
			throw new CustomException("No such a customer found");
		} else {
			return customerRepository.getById(customerId);
		}

	}

	@Override
	public Customer findByCustomerName(String customerName) throws CustomException {

		if (customerRepository.findByCustomerName(customerName).getCustomerName().equalsIgnoreCase(customerName)) {
			throw new CustomException("No such a customer found");
		} else {
			return customerRepository.findByCustomerName(customerName);
		}

	}

	@Override
	public String createCustomer(Customer customer) throws CustomException {

		customerRepository.save(customer);
		return "Created Sucessfully";

	}

	@Override
	public String deleteByCustomerId(int customerId) throws CustomException {
		Optional<Customer> optional = customerRepository.findById(customerId);
		if (!optional.isPresent()) {
			throw new CustomException("No record found");
		}	else {
			customerRepository.deleteById(customerId);
				return "deleted Sucessfully";
			}
	}

	@Override
	public String deleteByCustomerName(String customerName) throws CustomException {
		Customer customer = customerRepository.findByCustomerName(customerName);
		if(customer==null) {
			throw new CustomException("no restaurent");
		} else {
			customerRepository.delete(customer);
			return "Deleted Sucessfully";
		}
	}
	
	
	@Override
	public String updateByCustomerId(Customer customer, int customerId) throws CustomException {
		if(customerRepository.existsById(customerId)) {
			customerRepository.save(customer);
			return "Updated Sucessfully";
		} else {
			throw new CustomException("No customer found at this Id");
		}
	}

	

	
	
	
	

	@Override
	public List<Restaurent> readall() throws CustomException{
	
		if (restaurentRepository.findAll() == null) {
			throw new CustomException("No record found");
		} else {
			return restaurentRepository.findAll();
		}
	}

	@Override
	public Restaurent findByRestaurentId(int restaurentId) throws CustomException {
		Optional<Restaurent> optional = restaurentRepository.findById(restaurentId);
		if (!optional.isPresent()) {
			throw new CustomException("No record found");
		} else {
			return restaurentRepository.getById(restaurentId);
		}

	}

	@Override
	public Restaurent findByRestaurentName(String restaurentName) throws CustomException {
		if (restaurentRepository.findByRestaurentName(restaurentName) == null) {
			throw new CustomException("No such a Restaurent found");
		} else {
			return restaurentRepository.findByRestaurentName(restaurentName);
		}
	}

	@Override
	public String createRestaurent(Restaurent restaurent) throws CustomException {
		
		restaurentRepository.save(restaurent);
		return "Created Sucessfully";

	}

	@Override
	public String deleteByRestaurentId(int restaurentId) throws CustomException {
		Optional<Restaurent> optional = restaurentRepository.findById(restaurentId);
		if (!optional.isPresent()) {
			throw new CustomException("No record found");
		}	else {
			 repository.deleteById(restaurentId);
				return "deleted Sucessfully";
			}
		
	}

	@Override
	public String deleteByRestaurentName(String restaurentName) throws CustomException {
		
		Restaurent restaurent = restaurentRepository.findByRestaurentName(restaurentName);
		if(restaurent==null) {
			throw new CustomException("no restaurent");
		} else {
			restaurentRepository.delete(restaurent);
			return "Deleted Sucessfully";
		}
		
	}

	@Override
	public String updateByRestaurentId(Restaurent restaurent, int restaurentId) throws CustomException {
		if(restaurentRepository.existsById(restaurentId)) {
			restaurentRepository.save(restaurent);
			return "Updated Sucessfully";
		} else {
			throw new CustomException("No Restaurent found at this Id");
		}
	}

	@Override
	public List<Orders> readMyOrders(int customerId) throws CustomException {
		
		return customerServiceImpl.readMyOrders(customerId);
	}

	

	
	

	
	
	
	

}
