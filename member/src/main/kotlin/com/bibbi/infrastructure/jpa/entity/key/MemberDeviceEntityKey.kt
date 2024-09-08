package com.bibbi.infrastructure.jpa.entity.key

import java.io.Serializable

class MemberDeviceEntityKey (

    val memberId : String,
    val fcmToken : String,

) : Serializable
