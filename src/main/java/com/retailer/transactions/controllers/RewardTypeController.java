package com.retailer.transactions.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.transactions.domains.RewardType;
import com.retailer.transactions.services.RewardTypeService;



@RestController
public class RewardTypeController {
	
	@Autowired 
	private RewardTypeService rewardTypeService;
	
	@GetMapping(value = "/rewardType/{id}")  
	private Optional<RewardType> getRewardType(@PathVariable("id") long id) {  
		return rewardTypeService.getRewardTypeByRewardPoints(id);  
	}  

	@PostMapping(value = "/addRewardType")  
	private ResponseEntity<RewardType> createCustomerTransaction(@RequestBody RewardType rewardType) {  		
		try {
			rewardTypeService.addRewardType(rewardType);   
        } catch (Exception exception) {
        	return new ResponseEntity<RewardType>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
		return new ResponseEntity<RewardType>(HttpStatus.CREATED);	
	}
	
	@PostMapping(value = "/addManyRewardTypes")  
	private ResponseEntity<List <RewardType>> createCustomerTransaction(@RequestBody List <RewardType> rewardTypes) {  		
		try {
			rewardTypeService.addManyRewardTypes(rewardTypes);   
        } catch (Exception exception) {
        	return new ResponseEntity<List <RewardType>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
		return new ResponseEntity<List <RewardType>>(HttpStatus.CREATED);	
	}
}
