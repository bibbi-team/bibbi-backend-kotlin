package com.bibbi.domain.model

import java.time.LocalDate

data class MemberPick(
    val pickId: String,
    val familyId: String,
    val fromMemberId: String,
    val date: LocalDate,
    val toMemberId: String,
)
