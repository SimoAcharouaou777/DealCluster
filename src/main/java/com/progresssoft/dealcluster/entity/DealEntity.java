package com.progresssoft.dealcluster.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "deals", uniqueConstraints = @UniqueConstraint(columnNames = "deal_unique_id"))
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DealEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "deal_unique_id", nullable = false, unique = true)
    private String dealUniqueId;

    @Column(name = "ordering_currency", length = 3, nullable = false)
    private String orderingCurrency;

    @Column(name = "target_currency", length = 3, nullable = false)
    private String targetCurrency;

    @Column(name = "deal_timestamp", nullable = false)
    private Instant dealTimestamp;

    @Column(name = "deal_amount", nullable = false, precision = 19, scale = 4)
    private BigDecimal dealAmount;
}
