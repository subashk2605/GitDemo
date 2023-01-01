package com.stg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.stg.entity.Customer;
import com.stg.entity.Food;
import com.stg.entity.Restaurent;

@Repository
public interface FoodRepository extends JpaRepository<Food, Integer> {

	public abstract Food findByFoodName(String foodName);

	@Query(value = "SELECT * from food WHERE restaurent_id =:restaurent_id ", nativeQuery = true)
	public abstract List<Food> findByAllRestaurentId(@Param(value = "restaurent_id") int restaurentId);

	@Query(value = "SELECT * from food WHERE food_catogory =:food_catogory", nativeQuery = true)
	public abstract List<Food> findByFoodCatogory(@Param(value = "food_catogory") String foodCatogory);

	@Query(value = "SELECT * from food WHERE food_name =:food_name", nativeQuery = true)
	public abstract List<Food> findByFoodName1(@Param(value = "food_name") String foodname);

	@Query(value = "SELECT * from food WHERE veg_nonveg =:veg_nonveg", nativeQuery = true)
	public abstract List<Food> findByVegOrNonveg(@Param(value = "veg_nonveg") String vegOrNonVeg);
}
