package com.base.foodDeliverySystem.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.base.foodDeliverySystem.bean.InputBean;
import com.base.foodDeliverySystem.bean.LocationBean;
import com.base.foodDeliverySystem.exception.RecordNotFoundException;
import com.base.foodDeliverySystem.model.CatalogEntity;
import com.base.foodDeliverySystem.model.LocationEntity;
import com.base.foodDeliverySystem.model.RestaurantEntity;
import com.base.foodDeliverySystem.repository.CatalogRepository;
import com.base.foodDeliverySystem.repository.LocationRepository;
import com.base.foodDeliverySystem.repository.RestaurantRepository;
import com.base.foodDeliverySystem.vo.CatalogeVO;


@Service
public class FoodDeliveryService {

	@Autowired
	private LocationRepository repository;

	@Autowired
	private RestaurantRepository restRepo;
	
	@Autowired
	private CatalogRepository cataRepo;

	public RestaurantEntity fillFoodDeliveryDetails(InputBean bean) {

		Optional<LocationEntity> localtion = repository.findById(bean.getLocationId());

		RestaurantEntity restEnt = new RestaurantEntity();
		if (localtion.isPresent()) {

			Set<CatalogEntity> catalog = new HashSet<>();
			
			bean.getCatalogs().forEach(catagory -> {
				CatalogEntity catagoryEntity = new CatalogEntity();
				BeanUtils.copyProperties(catagory, catagoryEntity);
				catalog.add(catagoryEntity);
			});
			
			restEnt.setRestName(bean.getRestName());
			restEnt.setRating(bean.getRating());
			restEnt.setLocations(localtion.get());
			restEnt.setCataloges(catalog);
		} else {
			throw new RecordNotFoundException("Invalid location details");
		}
		
		return restRepo.save(restEnt);

	}

	public LocationEntity setLocation(LocationBean location) {

		LocationEntity locationEnt = new LocationEntity();
		locationEnt.setAreaName(location.getAreaName());
		locationEnt.setZipcode(location.getZipcode());

		return repository.save(locationEnt);

	}

	public List<CatalogeVO> searchByItemName(String item) {
		List<CatalogEntity> list = cataRepo.findByItemNameIs(item);
		
		List<CatalogeVO> listOfMenu = new ArrayList<>();
		
		for(CatalogEntity entity : list) {
			
			CatalogeVO menuDetails = new CatalogeVO();
			menuDetails.setRestName(entity.getRestaurantEntity().getRestName());
			menuDetails.setRating(entity.getRestaurantEntity().getRating());
			menuDetails.setItemName(entity.getItemName());
			menuDetails.setPrice(entity.getPricing());
			listOfMenu.add(menuDetails);
		}
		
		return listOfMenu;
	}

}
