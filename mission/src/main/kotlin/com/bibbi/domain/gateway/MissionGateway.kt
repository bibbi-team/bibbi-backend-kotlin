package com.bibbi.domain.gateway

import com.bibbi.domain.model.Mission

interface MissionGateway {
    fun findRandomMissionExcludingIds(excludingIds: List<String>): Mission?
}
