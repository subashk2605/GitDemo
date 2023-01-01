package com.stg.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stg.entity.Customer;
import com.stg.entity.Restaurent;

@Repository
public interface RestaurentRepository extends JpaRepository<Restaurent, Integer> {

	public abstract Restaurent findByRestaurentName(String restaurentName);

}
