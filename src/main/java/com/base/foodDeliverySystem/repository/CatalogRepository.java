package com.base.foodDeliverySystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.base.foodDeliverySystem.model.CatalogEntity;

@Repository
public interface CatalogRepository extends JpaRepository<CatalogEntity, Integer> {

	//@Query(" select * from CatalogEntity where ")
	List<CatalogEntity> findByItemNameIs(String itemName);

}
