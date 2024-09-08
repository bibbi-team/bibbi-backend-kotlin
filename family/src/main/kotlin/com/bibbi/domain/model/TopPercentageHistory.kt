package com.bibbi.domain.model

import java.time.LocalDateTime

data class TopPercentageHistory(
    val topPercentageHistoryId: TopPercentageHistoryId,
    val family: Family,
    var topPercentage: Int,
    val createdAt : LocalDateTime?,
    val updatedAt : LocalDateTime?,
)
