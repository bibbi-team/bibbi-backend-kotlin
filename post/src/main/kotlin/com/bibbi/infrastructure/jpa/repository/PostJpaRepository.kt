package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.PostEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface PostJpaRepository : JpaRepository<PostEntity, String> {
    fun findAllByFamilyIdAndCreatedAtBetween(familyId: String, start: LocalDateTime, end: LocalDateTime): List<PostEntity>
}
