package com.bibbi.domain.model

import java.time.LocalDateTime

data class MemberQuitReason (

    val memberId : String,
    val reasonId : MemberQuitReasonType,
    val createdAt : LocalDateTime?,
    val updatedAt : LocalDateTime?,

)
