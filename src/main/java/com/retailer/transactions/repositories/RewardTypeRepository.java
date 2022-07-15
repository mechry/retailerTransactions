package com.retailer.transactions.repositories;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.retailer.transactions.domains.RewardType;


@Repository
public interface RewardTypeRepository extends JpaRepository<RewardType, Long> {
}
