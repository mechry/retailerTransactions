package com.retailer.transactions.controllers;



import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.retailer.transactions.domains.PurchasesHistory;
import com.retailer.transactions.services.PurchasesHistoryService;



@RestController
public class PurchasesHistoryController {
	
	@Autowired 
	private PurchasesHistoryService purchasesHistoryService;
	

	@PostMapping(value = "/addCustomerTransaction")  
	private ResponseEntity<PurchasesHistory> addCustomerTransaction(@RequestBody PurchasesHistory purchasesHistory) {  		
		try {
			purchasesHistoryService.addCustomerTransaction(purchasesHistory);  
        } catch (Exception exception) {
        	return new ResponseEntity<PurchasesHistory>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
		return new ResponseEntity<PurchasesHistory>(HttpStatus.CREATED);	
	}  

	@PostMapping(value = "/addManyCustomerTransactions")  
	private ResponseEntity<List <PurchasesHistory>> addManyCustomerTransaction(@RequestBody List <PurchasesHistory> purchasesHistories) {  		
		try {
			purchasesHistoryService.addManyCustomerTransaction(purchasesHistories);  
        } catch (Exception exception) {
        	return new ResponseEntity<List<PurchasesHistory>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
		return new ResponseEntity<List<PurchasesHistory>>(HttpStatus.CREATED);	
	}  
	
	@GetMapping("/totalRPEPerCustomerForLast3Months")
	private Map <String, Integer> getTotalRewardPointsEarnedPerCustomerForLast3Months() {
	      return purchasesHistoryService.getTotalRewardPointsEarnedPerCustomerForLast3Months();
	   }
	
	@GetMapping("/rewardPEPerCustomerForOneMonth")
	private Map<String, Map<Object, Integer>> getRewardPointsEarnedPerCustomerForOneMonths() {
	      return purchasesHistoryService.getRewardPointsEarnedPerCustomerForOneMonth();
	   }	
	
}
