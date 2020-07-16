package com.base.foodDeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.foodDeliverySystem.model.LocationEntity;
import com.base.foodDeliverySystem.model.RestaurantEntity;

@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity, Integer> {

}
