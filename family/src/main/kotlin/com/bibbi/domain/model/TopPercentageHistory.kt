package com.bibbi.domain.model

import java.time.LocalDateTime

data class TopPercentageHistory (

    val familyId: String,
    val year: Int,
    val month: Int,
    var topPercentage: Int,
    val createdAt : LocalDateTime,
    val updatedAt : LocalDateTime,

)
