package com.progresssoft.dealcluster.controller;

import com.progresssoft.dealcluster.dto.DealRequestDto;
import com.progresssoft.dealcluster.entity.DealEntity;
import com.progresssoft.dealcluster.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/deals")
@RequiredArgsConstructor
public class DealController {

    private final DealService dealService;

    @PostMapping
    public ResponseEntity<?> importDeal(@Validated @RequestBody DealRequestDto dto) {
        if (dealService.existsByDealUniqueId(dto.getDealUniqueId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Deal already imported: " + dto.getDealUniqueId());
        }
        DealEntity saved = dealService.saveDeal(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(saved);
    }
}
