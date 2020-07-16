package com.base.foodDeliverySystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.foodDeliverySystem.model.LocationEntity;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {

}
