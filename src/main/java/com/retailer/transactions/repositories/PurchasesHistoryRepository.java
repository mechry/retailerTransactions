package com.retailer.transactions.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.retailer.transactions.domains.PurchasesHistory;



public interface PurchasesHistoryRepository extends JpaRepository<PurchasesHistory, Long> {

	@Query(value = "select * from purchases_history ct where ct.trans_date  > DATEADD('month',-3, CURRENT_DATE)", nativeQuery = true)
	List <PurchasesHistory> findAllCustomerTransactionForLast3Months();
}
