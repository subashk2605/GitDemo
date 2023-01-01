package com.stg.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FoodDto {
	
	private String foodCatogory;
	private String vegOrNonveg;
	private String foodName;
	private float foodPrice;
	private int quantity;
	
	
}
