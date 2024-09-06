package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.TopPercentageHistory
import jakarta.persistence.*

@Entity(name = "family_top_percentage_history")
class TopPercentageHistoryEntity (

    @EmbeddedId
    val topPercentageHistoryId: TopPercentageHistoryIdEntity,

    @MapsId("familyId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_id", referencedColumnName = "family_id", columnDefinition = "CHAR(26)", nullable = false)
    val family: FamilyEntity,

    @Column(name = "top_percentage", nullable = false)
    val topPercentage: Int,
) : BaseEntity() {

    fun toDomain() = TopPercentageHistory (
        topPercentageHistoryId = topPercentageHistoryId.toDomain(),
        family = family.toDomain(),
        topPercentage = topPercentage
    )

    companion object {
        fun fromDomain(topPercentageHistory: TopPercentageHistory) = with(topPercentageHistory) {
            TopPercentageHistoryEntity(
                topPercentageHistoryId = TopPercentageHistoryIdEntity.fromDomain(topPercentageHistoryId),
                family = FamilyEntity.fromDomain(family),
                topPercentage = topPercentage
            )
        }
    }
}