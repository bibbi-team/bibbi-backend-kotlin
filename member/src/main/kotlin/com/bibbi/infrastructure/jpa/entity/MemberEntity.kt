package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.Member
import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity(name = "members")
@Table(indexes = [
    Index(name = "member_idx1", columnList = "family_id"),
])
class MemberEntity (

    @Id
    @Column(name = "member_id", length = 26, columnDefinition = "CHAR(26)", nullable = false)
    val id : String,

    @Column(name = "family_id", length = 26, columnDefinition = "CHAR(26)", nullable = false)
    val familyId : String,

    @Column(name = "day_of_birth", nullable = false)
    val dayOfBirth : LocalDate,

    @Column(name = "name", nullable = false)
    val name : String,

    @Column(name = "profile_image_url")
    val profileImageUrl : String?,

    @Column(name = "profile_img_key")
    val profileImgKey : String?,

    @Column(name = "family_join_at")
    val familyJoinAt : LocalDateTime?,

) : DeletableBaseEntity() {

    fun toDomain() = Member (
        id = id,
        familyId = familyId,
        dayOfBirth = dayOfBirth,
        name = name,
        profileImageUrl = profileImageUrl,
        profileImgKey = profileImgKey,
        familyJoinAt = familyJoinAt,
        createdAt = createdAt,
        updatedAt = updatedAt,
        deletedAt = deletedAt,
    )

    companion object {
        fun fromDomain(member: Member) = with(member) {
            MemberEntity(
                id = id,
                familyId = familyId,
                dayOfBirth = dayOfBirth,
                name = name,
                profileImageUrl = profileImageUrl,
                profileImgKey = profileImgKey,
                familyJoinAt = familyJoinAt,
            ).apply {
                deletedAt = member.deletedAt
            }
        }
    }
}