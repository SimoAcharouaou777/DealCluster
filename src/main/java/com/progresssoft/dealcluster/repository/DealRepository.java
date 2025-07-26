package com.progresssoft.dealcluster.repository;

import com.progresssoft.dealcluster.entity.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<DealEntity, Long> {
    boolean existsByDealUniqueId(String dealUniqueId);
}
