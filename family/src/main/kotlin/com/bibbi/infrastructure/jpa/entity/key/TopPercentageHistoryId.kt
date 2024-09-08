package com.bibbi.infrastructure.jpa.entity.key

import jakarta.persistence.Column
import java.io.Serializable

class TopPercentageHistoryId (

    @Column(name = "family_id", length = 26, columnDefinition = "CHAR(26)", nullable = false)
    val familyId: String,

    @Column(name = "history_year", nullable = false)
    val year: Int,

    @Column(name = "history_month", nullable = false)
    val month: Int,
) : Serializable {
    fun toDomain() = TopPercentageHistoryId (
        familyId = familyId,
        year = year,
        month = month
    )

    companion object {
        fun fromDomain(topPercentageHistoryId: TopPercentageHistoryId) = with(topPercentageHistoryId) {
            TopPercentageHistoryId(
                familyId = familyId,
                year = year,
                month = month
            )
        }
    }
}