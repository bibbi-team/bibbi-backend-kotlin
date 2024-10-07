package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.TopPercentageHistoryEntity
import com.bibbi.infrastructure.jpa.entity.key.TopPercentageHistoryKey
import org.springframework.data.jpa.repository.JpaRepository

interface TopPercentageHistoryJpaRepository : JpaRepository<TopPercentageHistoryEntity, TopPercentageHistoryKey> {
}
