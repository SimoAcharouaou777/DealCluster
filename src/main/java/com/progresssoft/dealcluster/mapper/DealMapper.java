package com.progresssoft.dealcluster.mapper;

import com.progresssoft.dealcluster.dto.DealRequestDto;
import com.progresssoft.dealcluster.entity.DealEntity;

public class DealMapper {

    public static DealEntity toEntity(DealRequestDto dto) {
        return DealEntity.builder()
                .dealUniqueId(dto.getDealUniqueId())
                .orderingCurrency(dto.getOrderingCurrency())
                .targetCurrency(dto.getTargetCurrency())
                .dealTimestamp(dto.getDealTimestamp())
                .dealAmount(dto.getDealAmount())
                .build();
    }
}
