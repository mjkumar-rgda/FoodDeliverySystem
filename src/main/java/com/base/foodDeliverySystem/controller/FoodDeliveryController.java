package com.base.foodDeliverySystem.controller;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.base.foodDeliverySystem.bean.InputBean;
import com.base.foodDeliverySystem.bean.LocationBean;
import com.base.foodDeliverySystem.model.LocationEntity;
import com.base.foodDeliverySystem.model.RestaurantEntity;
import com.base.foodDeliverySystem.service.FoodDeliveryService;
import com.base.foodDeliverySystem.vo.CatalogeVO;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/foodDeliverySystem")
public class FoodDeliveryController {
	
	@Autowired
	private FoodDeliveryService service;

	@ApiOperation("api to add location")
	@PostMapping("/addLocation")
	public ResponseEntity<LocationEntity> addLocation(@RequestBody LocationBean location) {
		
		LocationEntity locationEntity = service.setLocation(location);
		
		return new ResponseEntity<LocationEntity>(locationEntity, HttpStatus.CREATED);
	}
	
	@ApiOperation("api to feed the details of Restaurant and Cataloge")
	@PostMapping("/fillDetails")
	public ResponseEntity<RestaurantEntity> fillFoodDeliveryDetails(@RequestBody InputBean inputBean) {
			
		 return new ResponseEntity<RestaurantEntity>(service.fillFoodDeliveryDetails(inputBean),HttpStatus.CREATED);
		
	}
	
	@ApiOperation("api to search Restaurant along with rating by itemName")
	@GetMapping("/{itemName}")
	public ResponseEntity<List<CatalogeVO>> searchByCataloge(@PathVariable String itemName){
		
		return new ResponseEntity<List<CatalogeVO>>(service.searchByItemName(itemName),HttpStatus.OK);
	}
	
	
	
}
