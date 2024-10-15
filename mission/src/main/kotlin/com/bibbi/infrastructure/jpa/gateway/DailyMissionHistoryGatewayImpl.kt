package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.DailyMissionHistoryGateway
import com.bibbi.infrastructure.jpa.repository.DailyMissionHistoryJpaRepository
import org.springframework.stereotype.Component

@Component
class DailyMissionHistoryGatewayImpl(
    private val dailyMissionHistoryJpaRepository: DailyMissionHistoryJpaRepository,
) : DailyMissionHistoryGateway {
}
