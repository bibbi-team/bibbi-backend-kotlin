package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.MemberQuitReasonType
import com.bibbi.domain.model.MemberQuitReason
import com.bibbi.infrastructure.jpa.entity.key.MemberQuitReasonEntityKey
import jakarta.persistence.*

@Entity(name = "member_quit_reason")
@IdClass(MemberQuitReasonEntityKey::class)
class MemberQuitReasonEntity (

    @Id
    @Column(name = "member_id", columnDefinition = "CHAR(26)")
    val memberId : String,

    @Id
    @Column(name = "reason_id", columnDefinition = "VARCHAR(255)")
    @Enumerated(EnumType.STRING)
    val reasonId : MemberQuitReasonType,

) : BaseEntity() {

    companion object {
        fun fromDomain(memberQuitReason : MemberQuitReason) = with(memberQuitReason) {
            MemberQuitReasonEntity(
                memberId = memberId,
                reasonId = reasonId,
            )
        }
    }

    fun toDomain() = MemberQuitReason(
        memberId = memberId,
        reasonId = reasonId,
    )
}