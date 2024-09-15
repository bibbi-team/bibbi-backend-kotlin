package com.bibbi.domain.model

data class MemberQuitReason (
    val memberId : String,
    val reasonId : MemberQuitReasonType,
)
