package com.bibbi.domain.gateway

import com.bibbi.domain.model.FamilyInviteLink

interface FamilyInviteLinkGateway {
    fun findById(inviteCode: String): FamilyInviteLink?
    fun findByFamilyId(familyId: String): FamilyInviteLink?
    fun save(familyInviteLink: FamilyInviteLink): FamilyInviteLink
}
