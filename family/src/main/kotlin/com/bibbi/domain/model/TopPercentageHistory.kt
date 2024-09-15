package com.bibbi.domain.model

data class TopPercentageHistory (
    val familyId: String,
    val year: Int,
    val month: Int,
    var topPercentage: Int,
)
