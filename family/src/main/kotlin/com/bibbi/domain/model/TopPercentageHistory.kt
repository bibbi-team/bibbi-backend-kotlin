package com.bibbi.domain.model

data class TopPercentageHistory(
    val topPercentageHistoryId: TopPercentageHistoryId,
    val family: Family,
    val topPercentage: Int
)
