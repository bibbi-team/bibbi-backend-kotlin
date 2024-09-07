package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.DailyMissionHistory
import jakarta.persistence.*
import lombok.*
import java.time.LocalDate

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Getter
@Entity(name = "daily_mission_history")
@Table(indexes = [
    Index(name = "daily_mission_history_idx", columnList = "mission_id")
])
class DailyMissionHistoryEntity private constructor(
    @Id
    @Column(name = "date", nullable = false)
    val date: LocalDate,

    @Column(name = "mission_id", columnDefinition = "CHAR(26)", nullable = false)
    val missionId: String
) : BaseEntity() {

    fun toDomain() = DailyMissionHistory(
        date = date,
        missionId = missionId
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as DailyMissionHistoryEntity

        return date == other.date && missionId == other.missionId
    }

    override fun hashCode(): Int {
        return date.hashCode()
    }

    companion object {
        fun fromDomain(dailyMissionHistory: DailyMissionHistory) = with(dailyMissionHistory) {
            DailyMissionHistoryEntity(
                date = date,
                missionId = missionId
            )
        }
    }
}
