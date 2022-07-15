package com.retailer.transactions.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.retailer.transactions.domains.RewardType;
import com.retailer.transactions.repositories.RewardTypeRepository;



@Service
public class RewardTypeService {
	
	@Autowired
	private RewardTypeRepository rewardTypeRepository;
	
	public Optional<RewardType> getRewardTypeByRewardPoints(long rewardPoints) { 
		return rewardTypeRepository.findById(rewardPoints);
	}
	
	public void addRewardType(RewardType RewardType) { 
		rewardTypeRepository.save(RewardType);
	}
	
	public void addManyRewardTypes(List <RewardType> rewardTypes) { 
		rewardTypeRepository.saveAll(rewardTypes);
	}

}
