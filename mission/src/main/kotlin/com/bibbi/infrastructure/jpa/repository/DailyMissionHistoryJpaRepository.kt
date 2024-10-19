package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.DailyMissionHistoryEntity
import org.springframework.data.jpa.repository.JpaRepository

interface DailyMissionHistoryJpaRepository : JpaRepository<DailyMissionHistoryEntity, String> {
}
