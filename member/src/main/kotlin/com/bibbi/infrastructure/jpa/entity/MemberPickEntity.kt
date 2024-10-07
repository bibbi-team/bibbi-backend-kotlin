package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.MemberPick
import jakarta.persistence.*
import java.time.LocalDate

@Entity(name = "member_pick")
@Table(indexes = [
    Index(name = "member_pick_idx1", columnList = "family_id"),
])
class MemberPickEntity(

    @Id
    @Column(name = "pick_id", length = 26, columnDefinition = "CHAR(26)")
    val pickId: String,

    @Column(name = "family_id", length = 26, columnDefinition = "CHAR(26)")
    val familyId: String,

    @Column(name = "from_member_id", length = 26, columnDefinition = "CHAR(26)")
    val fromMemberId: String,

    @Column(name = "date", columnDefinition = "DATE")
    val date: LocalDate,

    @Column(name = "to_member_id", columnDefinition = "CHAR(26)")
    val toMemberId: String,

) : BaseEntity() {

    companion object {
        fun fromDomain(memberPick: MemberPick) = with(memberPick) {
            MemberPickEntity(
                pickId = pickId,
                familyId = familyId,
                fromMemberId = fromMemberId,
                date = date,
                toMemberId = toMemberId,
            )
        }
    }

    fun toDomain() = MemberPick(
        pickId = pickId,
        familyId = familyId,
        fromMemberId = fromMemberId,
        date = date,
        toMemberId = toMemberId,
    )
}
