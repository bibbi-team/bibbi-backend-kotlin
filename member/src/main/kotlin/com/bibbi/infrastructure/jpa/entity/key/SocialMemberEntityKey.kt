package com.bibbi.infrastructure.jpa.entity.key

import com.bibbi.domain.model.SocialLoginProvider

class SocialMemberEntityKey (

    val provider : SocialLoginProvider,
    val identifier : String,

)
