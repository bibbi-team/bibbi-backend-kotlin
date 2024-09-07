package com.bibbi.domain.model

import java.time.LocalDate

data class DailyMissionHistory(
    val date: LocalDate,
    val missionId: String
) {
    companion object {
        fun newDailyMissionHistory(date: LocalDate, missionId: String): DailyMissionHistory {
            return DailyMissionHistory(date = date, missionId = missionId)
        }
    }
}
