package com.retailer.transactions.domains;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.Id;  
import javax.persistence.Table;  

@Getter
@Setter
@Entity  
@Table
@NoArgsConstructor
@AllArgsConstructor
public class RewardType {

	@Id
	@Column(nullable = false)
	private long purchaseLimit;
	@Column(nullable = false)
	private int rewardPoint;
}
