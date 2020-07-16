package com.base.foodDeliverySystem.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "RESTAURANT")
public class RestaurantEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "rest_id")
	private Integer restId;
	private String restName;
	private Integer rating;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinTable(name = "LOC_REST", joinColumns = @JoinColumn(name = "rest_id"), inverseJoinColumns = {
			@JoinColumn(name = "loc_id") })
	private LocationEntity locations;

	@OneToMany(targetEntity = CatalogEntity.class ,cascade = CascadeType.ALL)
	//@JoinTable(name = "REST_CATALOG", joinColumns = @JoinColumn(name = "rest_id"), inverseJoinColumns = {@JoinColumn(name = "cata_id") })
	private Set<CatalogEntity> cataloges;

	public RestaurantEntity() {

	}

	public Integer getRestId() {
		return restId;
	}

	public void setRestId(Integer restId) {
		this.restId = restId;
	}

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

	public LocationEntity getLocations() {
		return locations;
	}

	public void setLocations(LocationEntity locations) {
		this.locations = locations;
	}

	public Set<CatalogEntity> getCataloges() {
		return cataloges;
	}

	public void setCataloges(Set<CatalogEntity> cataloges) {
		this.cataloges = cataloges;
	}

}
