package com.stg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.stg.entity.Customer;
import com.stg.entity.Food;
import com.stg.entity.Orders;
import com.stg.entity.Restaurent;
import com.stg.exception.CustomException;
import com.stg.service.QuickFoodsService;
import com.stg.service.QuickFoodsServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/admin")
public class QuickFoodsController {

	@Autowired
	private QuickFoodsServiceImpl service;

	@GetMapping(value = "readallcustomers")
	private List<Customer> readall() throws CustomException {
		return service.readAll();
	}

	@GetMapping(value = "readbycustomerid/{id}")
	public Customer findByCustomerId(@PathVariable("id") int customerId) throws CustomException {
		return service.findByCustomerId(customerId);
	}

	@GetMapping(value = "readbycustomername/{name}")
	public ResponseEntity<Customer> findByCustomerName(@PathVariable("name") String customerName)
			throws CustomException {
		return new ResponseEntity<Customer>(service.findByCustomerName(customerName), HttpStatus.OK);
	}

	@PostMapping(value = "createnewcustomer")
	public ResponseEntity<String> createCustomer(@RequestBody Customer customer) throws CustomException {
		return new ResponseEntity<String>(service.createCustomer(customer), HttpStatus.OK);

	}

	@DeleteMapping("deletebycustomerid/{id}")
	public ResponseEntity<String> deleteByCustomerId(@PathVariable int customerId) throws CustomException {
		return new ResponseEntity<String>(service.deleteByCustomerId(customerId), HttpStatus.OK);

	}

	@DeleteMapping("deletebycustomername/{name}")
	public ResponseEntity<String> deleteByCustomerName(@PathVariable String customerName) throws CustomException {
		return new ResponseEntity<String>(service.deleteByCustomerName(customerName), HttpStatus.OK);

	}

	@PutMapping(value = "updatecustomerbyid")
	public ResponseEntity<String> updateByCustomerId(@RequestBody Customer customer, @RequestParam int customerId)
			throws CustomException {
		return new ResponseEntity<String>(service.updateByCustomerId(customer, customerId), HttpStatus.OK);
	}

	@GetMapping(value = "readallrestaurentswithfoods")
	public List<Restaurent> restaurents() throws CustomException {
		return service.readall();
	}

	@GetMapping(value = "getbyrestaurentid/{id}")
	public ResponseEntity<Restaurent> findByRestaurentId(@PathVariable("id") int restaurentId) throws CustomException {
		return new ResponseEntity<Restaurent>(service.findByRestaurentId(restaurentId), HttpStatus.OK);
	}

	@GetMapping(value = "getbyrestaurentname/{resname}")
	public ResponseEntity<Restaurent> findByRestaurentName(@PathVariable("resname") String restaurentName)
			throws CustomException {
		return new ResponseEntity<Restaurent>(service.findByRestaurentName(restaurentName), HttpStatus.OK);
	}

	@PostMapping(value = "createrestaurent")
	public String createRestaurent(@RequestBody Restaurent restaurent) throws CustomException {
		return service.createRestaurent(restaurent);

	}

	@DeleteMapping("deletebyrestaurentid/{id}")
	public ResponseEntity<String> deleteRestaurent(@PathVariable("id") int restaurentId) throws CustomException {
		return new ResponseEntity<String>(service.deleteByRestaurentId(restaurentId), HttpStatus.OK);

	}

	@DeleteMapping("deletebyrestaurentname/{name}")
	public ResponseEntity<String> deleteByRestaurentName(@PathVariable("name") String restaurentName)
			throws CustomException {
		return new ResponseEntity<String>(service.deleteByRestaurentName(restaurentName), HttpStatus.OK);

	}

	@PutMapping(value = "updaterestaurentbyid")
	public ResponseEntity<String> updateByRestaurentId(@RequestBody Restaurent restaurent,
			@RequestParam int restaurentId) throws CustomException {
		return new ResponseEntity<String>(service.updateByRestaurentId(restaurent, restaurentId), HttpStatus.OK);
	}
	
	@GetMapping(value = "readallorders/{customerId}/{orderId}")
	public  List<Restaurent> readMyOrders(@PathVariable int customerId ,@PathVariable int orderId) throws CustomException {
		
		return service.readall();
		
	}

}
