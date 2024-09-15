package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.TopPercentageHistory
import com.bibbi.infrastructure.jpa.entity.key.TopPercentageHistoryKey
import jakarta.persistence.*

@Entity(name = "family_top_percentage_history")
@IdClass(TopPercentageHistoryKey::class)
class TopPercentageHistoryEntity (

    @Id
    @Column(name = "family_id", length = 26, columnDefinition = "CHAR(26)", nullable = false)
    val familyId: String,

    @Id
    @Column(name = "history_year", nullable = false)
    val year: Int,

    @Id
    @Column(name = "history_month", nullable = false)
    val month: Int,

    @Column(name = "top_percentage", nullable = false)
    val topPercentage: Int,

) : BaseEntity() {

    companion object {
        fun fromDomain(topPercentageHistory: TopPercentageHistory) = with(topPercentageHistory) {
            TopPercentageHistoryEntity(
                familyId = familyId,
                year = year,
                month = month,
                topPercentage = topPercentage
            )
        }
    }

    fun toDomain() = TopPercentageHistory (
        familyId = familyId,
        year = year,
        month = month,
        topPercentage = topPercentage,
    )
}
