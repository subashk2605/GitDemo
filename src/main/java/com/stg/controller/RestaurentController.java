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
import com.stg.entity.Food;
import com.stg.entity.Restaurent;
import com.stg.exception.CustomException;
import com.stg.service.RestaurentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(name = "/restaurent")
public class RestaurentController {

	@Autowired
	private RestaurentService service;
	
	
	@PostMapping(value = "createrestaurent/{restaurentId}/{restaurenyNo}/{restaurentName}/{restaurentPhNo}/{restaurentEmail}/{password}/{street}/{area}/{city}/{state}")
	public  String createRestaurent( @PathVariable int restaurentId,@PathVariable int restaurenyNo,@PathVariable String restaurentName ,@PathVariable String restaurentPhNo,@PathVariable String restaurentEmail ,@PathVariable  String password ,@PathVariable String street ,@PathVariable String area ,@PathVariable String city ,@PathVariable String state)throws CustomException {
		return service.createRestaurent(restaurentId, restaurenyNo, restaurentName, restaurentPhNo, restaurentEmail,password, street, area, city, state);
		
	}
	

	@PostMapping(value = "createfood/{restaurentId}/{foodCatogory}/{vegOrNonVeg}/{foodName}/{price}/{quantity}")
	public String createFood(@PathVariable int restaurentId, 
			@PathVariable String foodCatogory,@PathVariable String vegOrNonVeg, @PathVariable String foodName, @PathVariable float price,
			@PathVariable int quantity) throws CustomException {
		return service.createFood(restaurentId,foodCatogory,vegOrNonVeg, foodName, price, quantity);

	}
	
	@PostMapping(value ="addfood")
	public ResponseEntity<String> createFood1(@RequestBody Food food) throws CustomException {
		return new ResponseEntity<String>(service.createFood1(food), HttpStatus.OK);
	}

	@GetMapping(value = "readfoods/{restaurentId}")
	public ResponseEntity<List<Food>> readfoods(@PathVariable int restaurentId) throws CustomException {

		return new ResponseEntity<List<Food>>(service.readfoods(restaurentId), HttpStatus.OK);
	}

	@PutMapping(value = "updatefoods/{foodId}")
	public ResponseEntity<String> updateFoods(@PathVariable int foodId, @RequestBody Food food) throws CustomException {
		return new ResponseEntity<String>(service.updateFoods(foodId, food), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "deletebyfoodid/{foodId}")
	public  String deleteFoodById(@PathVariable int foodId) throws CustomException {
		return service.deleteFoodById(foodId);
		
	}

}
