package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.TopPercentageHistoryGateway
import com.bibbi.domain.model.TopPercentageHistory
import com.bibbi.infrastructure.jpa.entity.TopPercentageHistoryEntity
import com.bibbi.infrastructure.jpa.entity.key.TopPercentageHistoryKey
import com.bibbi.infrastructure.jpa.repository.TopPercentageHistoryJpaRepository
import org.springframework.stereotype.Component

@Component
class TopPercentageHistoryGatewayImpl(
    private val topPercentageHistoryJpaRepository: TopPercentageHistoryJpaRepository
) : TopPercentageHistoryGateway {

    override fun save(topPercentageHistory: TopPercentageHistory): TopPercentageHistory {
        return topPercentageHistoryJpaRepository
            .save(TopPercentageHistoryEntity.fromDomain(topPercentageHistory))
            .toDomain();
    }

    override fun findById(familyId: String, year: Int, month: Int): TopPercentageHistory? {
        return topPercentageHistoryJpaRepository
            .findById(TopPercentageHistoryKey(familyId, year, month))
            .orElse(null)
            ?.toDomain();
    }
}
