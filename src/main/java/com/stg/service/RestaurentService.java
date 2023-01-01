package com.stg.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.stg.entity.Food;
import com.stg.exception.CustomException;

@Service
public interface RestaurentService {
	
	public abstract String createRestaurent(int restaurentId, int restaurenyNo, String restaurentName , String restaurentPhNo, String restaurentEmail ,String password , String street , String area , String city , String state)throws CustomException;

	public abstract String createFood(int restaurentId , String foodCatogory ,String vegOrNonVeg, String foodName ,float price , int quantity ) throws CustomException;
	
	public abstract String createFood1(Food food) throws CustomException;

	public abstract List<Food> readfoods(int restaurentId) throws CustomException;

	public abstract String updateFoods(int foodId, Food food) throws CustomException;
	
	public abstract String deleteFoodById(int foodId) throws CustomException;

}
