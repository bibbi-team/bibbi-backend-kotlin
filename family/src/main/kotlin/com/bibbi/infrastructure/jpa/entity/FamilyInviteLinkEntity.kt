package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.FamilyInviteLink
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "family_invite_link")
class FamilyInviteLinkEntity (

    @Id
    @Column(name = "link_id", columnDefinition = "CHAR(20)", nullable = false)
    val linkId : String,

    @Column(name = "family_id", columnDefinition = "CHAR(26)", nullable = false)
    val familyId : String,

) : BaseEntity() {

    companion object {
        fun fromDomain(familyInviteLink: FamilyInviteLink) = with(familyInviteLink) {
            FamilyInviteLinkEntity(
                linkId = linkId,
                familyId = familyId,
            )
        }
    }

    fun toDomain() = FamilyInviteLink(
        linkId = linkId,
        familyId = familyId,
    )
}
