package com.stg.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stg.dto.FoodDto;
import com.stg.entity.Customer;
import com.stg.entity.Food;
import com.stg.entity.Orders;
import com.stg.entity.Payment;
import com.stg.entity.Restaurent;
import com.stg.exception.CustomException;
import com.stg.service.CustomerServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private CustomerServiceImpl service;

	@Autowired
	private ModelMapper mapper;

	@PostMapping(value = "addcustomer/{customerId}/{customerName}/{customerPhNo}/{email}/{password}/{doorNo}/{street}/{city}/{area}/{state}/{zipcode}")
	public String createCustomer(@PathVariable int customerId, @PathVariable String customerName,
			@PathVariable String customerPhNo, @PathVariable String email,@PathVariable String password ,@PathVariable String doorNo,
			@PathVariable String street, @PathVariable String city, @PathVariable String area,
			@PathVariable String state, @PathVariable int zipcode) throws CustomException {
		return service.addCustomer(customerId, customerName, customerPhNo, email,password ,doorNo, street, city, area, state,
				zipcode);
	}

	@PostMapping(value = "createaddress/{customerId}/{addressId}/{doorNo}/{street}/{city}/{area}/{state}/{zipcode}")
	public String createAddress(@PathVariable int customerId, @PathVariable int addressId, @PathVariable String doorNo,
			@PathVariable String street, @PathVariable String city, @PathVariable String area,
			@PathVariable String state, @PathVariable int zipcode) throws CustomException {
		return service.createAddress(customerId, addressId, doorNo, street, city, area, state, zipcode);

	}

	@PostMapping(value = "createcustomer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) throws CustomException {
		return new ResponseEntity<String>(service.createCustomer(customer), HttpStatus.OK);

	}

	@GetMapping(value = "readfoods")
	public ResponseEntity<List<FoodDto>> readfoodMenu() throws CustomException {
		List<Food> foods = service.readfoodMenu();
		Type listType = new TypeToken<List<FoodDto>>() {
		}.getType();
		List<FoodDto> foodDtos = mapper.map(foods, listType);
		return new ResponseEntity<List<FoodDto>>(foodDtos, HttpStatus.OK);

	}

//	@PostMapping(value = "placeorders/{foodname}/{quantity}/{customerId}/{payment}")
//	public ResponseEntity<Orders> placeOrders(@PathVariable String foodname, @PathVariable int quantity,
//			@PathVariable int customerId, @PathVariable String payment) throws CustomException {
//		return new ResponseEntity<Orders>(service.placeOrders(foodname, quantity, customerId, payment), HttpStatus.OK);
//
//	}

	@DeleteMapping(value = "cancelorders")
	public ResponseEntity<String> cancelOrder(@RequestParam int customerId, @RequestParam int orderId)
			throws CustomException {

		return new ResponseEntity<String>(service.cancelOrder(customerId, orderId), HttpStatus.ACCEPTED);
	}

	@GetMapping(value = "readorders/{customerId}")
	public ResponseEntity<List<Orders>> readMyOrders(@PathVariable int customerId) throws CustomException {

		return new ResponseEntity<List<Orders>>(service.readMyOrders(customerId), HttpStatus.OK);
	}

	@GetMapping(value = "readfoodbycatogory/{catogory}")
	public List<Food> readFoodByCatogory(@PathVariable String catogory) throws CustomException {
		return service.readFoodByCatogory(catogory);

	}

	@GetMapping(value = "readbyfoodname/{name}")
	public List<Food> readFoodByName(@PathVariable String name) throws CustomException {
		return service.readFoodByName(name);

	}

	@GetMapping(value = "readbyvegornonveg/{name}")
	public List<Food> readByVegOrNonveg(@PathVariable String  name) throws CustomException {
		return service.readByVegOrNonveg(name);
	}
	
	@GetMapping(value = "readallrestaurentswithfoods")
	public List<Restaurent> restaurents() throws CustomException {
		return service.readall();
	}
	
	
	@GetMapping(value = "readfoodbyrestaurent/{restaurentId}")
	public   List<Food> readfoodByRestaurent(@PathVariable int restaurentId) throws CustomException {
		return service.readfoodByRestaurent(restaurentId);
		
	}
	
	@PostMapping(value = "placeorders/{foodId}/{quantity}/{customerId}/{payment}")
	public  Orders placeOrders(@PathVariable int foodId ,@PathVariable int quantity ,@PathVariable int customerId ,@PathVariable String payment) throws CustomException{
		return service.placeOrders(foodId, quantity, customerId, payment);
		
	}

}
