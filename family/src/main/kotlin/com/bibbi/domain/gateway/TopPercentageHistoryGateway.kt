package com.bibbi.domain.gateway

import com.bibbi.domain.model.TopPercentageHistory

interface TopPercentageHistoryGateway {
    fun findById(familyId: String, year: Int, month: Int): TopPercentageHistory?
    fun save(topPercentageHistory: TopPercentageHistory): TopPercentageHistory
}