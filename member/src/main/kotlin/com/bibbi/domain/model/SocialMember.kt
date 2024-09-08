package com.bibbi.domain.model

data class SocialMember (

    val provider : SocialLoginProvider,
    var identifier : String,
    val memberId : String,

)
