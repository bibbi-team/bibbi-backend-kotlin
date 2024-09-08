package com.bibbi.domain.model

import java.time.LocalDateTime

data class FamilyInviteLink (

    val linkId: String,
    val familyId: String,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,

) : SerializableDeepLink {

    override fun serialize(): Map<String, String> {
        return mapOf(
            "familyId" to familyId,
        )
    }
}