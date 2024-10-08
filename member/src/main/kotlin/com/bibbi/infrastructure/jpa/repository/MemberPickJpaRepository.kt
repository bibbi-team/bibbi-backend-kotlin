package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.MemberPickEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDate

interface MemberPickJpaRepository : JpaRepository<MemberPickEntity, String> {

    fun findByFamilyIdAndFromMemberIdAndDateAndToMemberId(
        familyId: String,
        fromMemberId: String,
        date: LocalDate,
        toMemberId: String
    ): MemberPickEntity?
    fun findAllByFamilyIdAndDateAndToMemberId(
        familyId: String,
        date: LocalDate,
        toMemberId: String
    ): List<MemberPickEntity>
    fun findAllByFamilyIdAndDateAndFromMemberId(
        familyId: String,
        date: LocalDate,
        fromMemberId: String
    ): List<MemberPickEntity>
}
