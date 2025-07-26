package com.progresssoft.dealcluster.service.impl;

import com.progresssoft.dealcluster.dto.DealRequestDto;
import com.progresssoft.dealcluster.entity.DealEntity;
import com.progresssoft.dealcluster.exception.DuplicateDealException;
import com.progresssoft.dealcluster.mapper.DealMapper;
import com.progresssoft.dealcluster.repository.DealRepository;
import com.progresssoft.dealcluster.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;

    @Override
    public boolean existsByDealUniqueId(String dealUniqueId) {
        return dealRepository.existsByDealUniqueId(dealUniqueId);
    }

    @Override
    @Transactional
    public DealEntity saveDeal(DealRequestDto dto) {
        if (existsByDealUniqueId(dto.getDealUniqueId())) {
            throw new DuplicateDealException("Deal already exists: " +dto.getDealUniqueId());
        }
        DealEntity dealEntity =  DealMapper.toEntity(dto);
        return dealRepository.save(dealEntity);
    }
}
