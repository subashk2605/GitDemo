package com.stg.service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stg.entity.Food;
import com.stg.entity.Restaurent;
import com.stg.exception.CustomException;
import com.stg.repository.FoodRepository;
import com.stg.repository.RestaurentRepository;

@Service
public class RestaurentServiceImpl implements RestaurentService {

	@Autowired
	private RestaurentRepository restaurentRepository;

	@Autowired
	private FoodRepository foodRepository;
	
	
	@Override
	public String createFood(int restaurentId, String foodCatogory,String vegOrNonVeg, String foodName, float price, int quantity
			) throws CustomException {
		Food food = new Food() ;
		Restaurent restaurent = restaurentRepository.findById(restaurentId).get();
	
		food.setFoodCatogory(foodCatogory);
		food.setVegOrNonveg(vegOrNonVeg);
		food.setFoodName(foodName);
		food.setFoodPrice(price);
		food.setQuantity(quantity);
		food.setRestaurentRef(restaurent);
		
	
		
		foodRepository.save(food);
		if(food!=null) {
			return "Food Added SucessFully";
		} else {
			throw  new CustomException("Please Enter a valid Data");
		}
		
	}

	@Override
	public String createFood1(Food food) throws CustomException {

		if (foodRepository.findAll() != food) {

			foodRepository.save(food);

			return "created Sucessfully";

		}

		else {
			throw new CustomException("food Already exist");
		}
	}

	@Override
	public List<Food> readfoods(int restaurentId) throws CustomException {

		if (restaurentRepository.existsById(restaurentId)) {
			return foodRepository.findByAllRestaurentId(restaurentId);
		} else {

			throw new CustomException("not having any foods");
		}

	}

	@Override
	public String updateFoods(int foodId, Food food) throws CustomException {
		if (foodRepository.existsById(foodId)) {

			foodRepository.save(food);

			return "Updated Sucessfully";
		} else {
			throw new CustomException("No such food found in your store");
		}
	}

	@Override
	public String createRestaurent(int restaurentId, int restaurenyNo, String restaurentName, String restaurentPhNo,
			String restaurentEmail,String password , String street, String area, String city, String state) throws CustomException {
		Restaurent restaurent =  new  Restaurent();
		restaurent.setRestaurentId(restaurentId);
		restaurent.setRestaurentNo(restaurentName);
		restaurent.setRestaurentName(restaurentName);
		restaurent.setRestaurentPhoneNo(restaurentPhNo);
		restaurent.setRestaurentEmail(restaurentEmail);
		restaurent.setPassword(password);
		restaurent.setRestaurentStreet(street);
		restaurent.setArea(area);
		restaurent.setRestaurentCity(city);
		restaurent.setRestaurentState(state);
		restaurentRepository.save(restaurent);
		if(restaurent!=null) {
			return "Created Sucesfully";
		} else {
			throw new  CustomException(" Registration failed");
		}
		
	}

	@Override
	public String deleteFoodById(int foodId) throws CustomException {

		
		foodRepository.deleteById(foodId);
		return "deleted sucessfully";
	}



}
