package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.MemberEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime

interface MemberJpaRepository : JpaRepository<MemberEntity, String> {

    fun findAllByFamilyIdAndDeletedAtIsNull(familyId: String): List<MemberEntity>
    fun findAllByFamilyIdAndDeletedAtIsNull(familyId: String, pageRequest: PageRequest): Page<MemberEntity>
    fun findAllByFamilyIdAndFamilyJoinAtBeforeAndDeletedAtIsNull(familyId: String, familyJoinAt: LocalDateTime): List<MemberEntity>
    fun findAllByDeletedAtIsNull(): List<MemberEntity>
    fun existsByIdAndDeletedAtIsNotNull(memberId: String): Boolean
}