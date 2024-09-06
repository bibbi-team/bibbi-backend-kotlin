package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.TopPercentageHistoryId
import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import lombok.EqualsAndHashCode
import java.io.Serializable

@Embeddable
@EqualsAndHashCode
class TopPercentageHistoryIdEntity (

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
            TopPercentageHistoryIdEntity(
                familyId = familyId,
                year = year,
                month = month
            )
        }
    }
}