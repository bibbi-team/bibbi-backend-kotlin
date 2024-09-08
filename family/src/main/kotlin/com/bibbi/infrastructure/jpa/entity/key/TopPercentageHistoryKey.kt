package com.bibbi.infrastructure.jpa.entity.key

import java.io.Serializable

class TopPercentageHistoryKey (

    val familyId: String,
    val year: Int,
    val month: Int,

) : Serializable
