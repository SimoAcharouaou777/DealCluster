package com.progresssoft.dealcluster.dto;

import jakarta.persistence.AssociationOverride;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DealRequestDto {

    @NotBlank
    String dealUniqueId;

    @NotBlank @Size(min = 3, max = 3)
    String orderingCurrency;

    @NotBlank @Size(min = 3, max = 3)
    String targetCurrency;

    @NotNull
    Instant dealTimestamp;

    @NotNull
    BigDecimal dealAmount;
}
