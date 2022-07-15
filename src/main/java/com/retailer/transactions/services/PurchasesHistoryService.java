package com.retailer.transactions.services;



import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailer.transactions.domains.PurchasesHistory;
import com.retailer.transactions.domains.RewardType;
import com.retailer.transactions.repositories.PurchasesHistoryRepository;
import com.retailer.transactions.repositories.RewardTypeRepository;
import com.retailer.transactions.utils.UtilitiesHelper;


@Service
public class PurchasesHistoryService {
	
	@Autowired
	private PurchasesHistoryRepository purchasesHistoryRepository;
	@Autowired
	private RewardTypeRepository rewardTypeRepository;
	
	
	private TreeMap <Long, Integer> rewardTypeMap                        = null;
	private List <PurchasesHistory> allCustomerTransactionForLast3Months = null;
	
	public void addCustomerTransaction(PurchasesHistory purchasesHistory) { 
		purchasesHistory.setEarnedPoint(calculateRewardEarnedPoints(purchasesHistory.getAmount()));
		purchasesHistoryRepository.save(purchasesHistory);
	}
	
	public void addManyCustomerTransaction(List <PurchasesHistory> purchasesHistories) { 
		purchasesHistories.stream().forEach(purchasesHistory -> addCustomerTransaction(purchasesHistory));
	}
	
	public Map<String, Integer> getTotalRewardPointsEarnedPerCustomerForLast3Months() { 		
		return getAllCustomerTransactionForLast3Months().stream()
	              .collect(Collectors.groupingBy(
	            		  PurchasesHistory::getCustomerId, 
	                  Collectors.summingInt(PurchasesHistory::getEarnedPoint)));
	}
	
	
	public  Map<String, Map<Object, Integer>> getRewardPointsEarnedPerCustomerForOneMonth() { 
		return getAllCustomerTransactionForLast3Months().stream()
	              .collect(Collectors.groupingBy(
	            		  PurchasesHistory::getCustomerId, 
	                  Collectors.groupingBy(trans -> UtilitiesHelper.dateFormaterHelper(trans.getTransDate()),
	                		  Collectors.summingInt(PurchasesHistory::getEarnedPoint))));
	}
	
	
	private List <PurchasesHistory> getAllCustomerTransactionForLast3Months() {
		if(allCustomerTransactionForLast3Months == null) {
			allCustomerTransactionForLast3Months = purchasesHistoryRepository.findAllCustomerTransactionForLast3Months();
		}
		return allCustomerTransactionForLast3Months;
	}
		
	private int calculateRewardEarnedPoints(double transactionAmount) {
		double amount = transactionAmount;
		int rewardPointsEarnedForEachTransaction = 0 ;
		Optional <Long> filterdRewardVlue = getFilterdRewardVlue(amount);
		 while (filterdRewardVlue.isPresent()){
			 long rewardValue = filterdRewardVlue.get();
			 rewardPointsEarnedForEachTransaction = (int) (rewardPointsEarnedForEachTransaction + (amount - rewardValue)*rewardTypeMap.get(rewardValue));
			 amount =  rewardValue;
			 filterdRewardVlue = getFilterdRewardVlue(rewardValue);
        }
		return rewardPointsEarnedForEachTransaction;
	}
	
	public Optional <Long> getFilterdRewardVlue(double amount) { 
		return getRewardTypeMap().descendingKeySet().stream().filter(rewardVlue -> rewardVlue < amount).findFirst();
	}
	
	private TreeMap <Long, Integer> getRewardTypeMap() { 
		if(rewardTypeMap == null) { 
			rewardTypeMap =  rewardTypeRepository.findAll().stream().collect(Collectors.toMap(RewardType::getPurchaseLimit, 
					RewardType::getRewardPoint, (o1, o2) -> o1, TreeMap::new));
		}		
		return rewardTypeMap;
	}
}
