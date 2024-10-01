package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.FamilyInviteLinkEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FamilyInviteLinkJpaRepository : JpaRepository<FamilyInviteLinkEntity, String> {
    fun findByFamilyId(familyId: String): FamilyInviteLinkEntity?
}