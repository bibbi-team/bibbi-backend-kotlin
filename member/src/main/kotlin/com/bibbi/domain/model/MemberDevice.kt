package com.bibbi.domain.model

import java.time.LocalDateTime

data class MemberDevice (

    val memberId : String,
    var fcmToken : String,
    val createdAt : LocalDateTime?,
    val updatedAt : LocalDateTime?,

)
