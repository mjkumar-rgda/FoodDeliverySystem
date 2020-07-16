package com.base.foodDeliverySystem.bean;

import java.util.Set;

import com.base.foodDeliverySystem.model.CatalogEntity;

public class InputBean {

	private Integer locationId;
	private String restName;
	private Integer rating;
	private Set<CatalogBean> catalogs;
	
	public String getRestName() {
		return restName;
	}
	public void setRestName(String restName) {
		this.restName = restName;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	public Set<CatalogBean> getCatalogs() {
		return catalogs;
	}
	public void setCatalogs(Set<CatalogBean> catalogs) {
		this.catalogs = catalogs;
	}
	public Integer getLocationId() {
		return locationId;
	}
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	
	
	
	
	
}
