package com.retailer.transactions.domains;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;  
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Getter
@Setter
@Entity  
@Table
@NoArgsConstructor
@AllArgsConstructor
public class PurchasesHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date transDate;
	@Column(nullable = false)
	private String customerId;
	@Column(nullable = false)
	private double amount;
	@Column(nullable = false)
	private int earnedPoint;

}
