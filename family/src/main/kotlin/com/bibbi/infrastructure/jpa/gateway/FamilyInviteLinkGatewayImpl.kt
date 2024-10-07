package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.FamilyInviteLinkGateway
import com.bibbi.domain.model.FamilyInviteLink
import com.bibbi.infrastructure.jpa.entity.FamilyInviteLinkEntity
import com.bibbi.infrastructure.jpa.repository.FamilyInviteLinkJpaRepository
import org.springframework.stereotype.Component

@Component
class FamilyInviteLinkGatewayImpl(
    private val familyInviteLinkJpaRepository: FamilyInviteLinkJpaRepository
) : FamilyInviteLinkGateway {

    override fun save(familyInviteLink: FamilyInviteLink): FamilyInviteLink {
        return familyInviteLinkJpaRepository
            .save(FamilyInviteLinkEntity.fromDomain(familyInviteLink))
            .toDomain();
    }

    override fun findById(inviteCode: String): FamilyInviteLink? {
        return familyInviteLinkJpaRepository
            .findById(inviteCode)
            .orElse(null)
            ?.toDomain()
    }

    override fun findByFamilyId(familyId: String): FamilyInviteLink? {
        return familyInviteLinkJpaRepository
            .findByFamilyId(familyId)
            ?.toDomain()
    }
}
