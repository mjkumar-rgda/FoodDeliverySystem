package com.base.foodDeliverySystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "CATALOGE")
public class CatalogEntity {
	
	@Id
	//@JsonIgnore
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cata_id")
	private Integer cataId;
	private String itemName;
	private Integer pricing;
	
	@ManyToOne
	@JsonIgnore
	private RestaurantEntity restaurantEntity;
	
	public CatalogEntity() {
		
	}
	
	public Integer getCataId() {
		return cataId;
	}
	public void setCataId(Integer cataId) {
		this.cataId = cataId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getPricing() {
		return pricing;
	}
	public void setPricing(Integer pricing) {
		this.pricing = pricing;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}
	
	

}
