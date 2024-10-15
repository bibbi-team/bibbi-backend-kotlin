package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.MissionGateway
import com.bibbi.domain.model.Mission
import com.bibbi.infrastructure.jpa.repository.MissionJpaRepository
import org.springframework.stereotype.Component

@Component
class MissionGatewayImpl(
    private val missionJpaRepository: MissionJpaRepository,
): MissionGateway {
    override fun findRandomMissionExcludingIds(excludingIds: List<String>): Mission? {
        val missionEntity = missionJpaRepository.findRandomMissionExcludingIds(excludingIds)
        return missionEntity?.toDomain()
    }
}
