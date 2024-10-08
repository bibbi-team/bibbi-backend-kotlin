package com.bibbi.domain.gateway

import com.bibbi.domain.model.SocialLoginProvider
import com.bibbi.domain.model.SocialMember

interface SocialMemberGateway {

    fun save(socialMember: SocialMember): SocialMember
    fun findById(provider: SocialLoginProvider, identifier: String): SocialMember?
    fun delete(socialMember: SocialMember)
    fun deleteAllByMemberId(memberId: String)
}
