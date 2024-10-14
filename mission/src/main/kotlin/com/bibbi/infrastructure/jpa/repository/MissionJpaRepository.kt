package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.MissionEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface MissionJpaRepository : JpaRepository<MissionEntity, String> {
    @Query(value = "SELECT * FROM mission WHERE mission_id NOT IN :excludingIds ORDER BY RAND() LIMIT 1", nativeQuery = true)
    fun findRandomMissionExcludingIds(excludingIds: List<String>): MissionEntity?
}
