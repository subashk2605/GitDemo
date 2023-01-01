package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.Customer;
import com.stg.entity.QuickFoods;

@Repository
public interface QuickFoodsRepository extends JpaRepository<QuickFoods, Integer>{
	


}
