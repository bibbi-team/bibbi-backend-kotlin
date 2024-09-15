package com.bibbi.domain.model

data class FamilyInviteLink (
    val linkId: String,
    val familyId: String,
) : SerializableDeepLink {

    override fun serialize(): Map<String, String> {
        return mapOf(
            "familyId" to familyId,
        )
    }
}
