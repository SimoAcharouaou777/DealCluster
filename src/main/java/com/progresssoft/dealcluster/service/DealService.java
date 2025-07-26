package com.progresssoft.dealcluster.service;

import com.progresssoft.dealcluster.dto.DealRequestDto;
import com.progresssoft.dealcluster.entity.DealEntity;

public interface DealService {
    DealEntity saveDeal(DealRequestDto dto);
    boolean existsByDealUniqueId(String dealUniqueId);
}
