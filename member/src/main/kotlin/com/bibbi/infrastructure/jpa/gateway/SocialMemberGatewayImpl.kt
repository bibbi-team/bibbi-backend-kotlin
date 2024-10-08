package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.SocialMemberGateway
import com.bibbi.domain.model.SocialLoginProvider
import com.bibbi.domain.model.SocialMember
import com.bibbi.infrastructure.jpa.entity.SocialMemberEntity
import com.bibbi.infrastructure.jpa.entity.key.SocialMemberEntityKey
import com.bibbi.infrastructure.jpa.repository.SocialMemberJpaRepository
import org.springframework.stereotype.Component

@Component
class SocialMemberGatewayImpl(
    private val socialMemberJpaRepository: SocialMemberJpaRepository
) : SocialMemberGateway {

    override fun save(socialMember: SocialMember): SocialMember {
        return socialMemberJpaRepository
            .save(SocialMemberEntity.fromDomain(socialMember))
            .toDomain()
    }

    override fun findById(provider: SocialLoginProvider, identifier: String): SocialMember? {
        return socialMemberJpaRepository
            .findById(SocialMemberEntityKey(provider, identifier))
            .orElse(null)
            ?.toDomain()
    }

    override fun delete(socialMember: SocialMember) {
        socialMemberJpaRepository.delete(SocialMemberEntity.fromDomain(socialMember))
    }

    override fun deleteAllByMemberId(memberId: String) {
        socialMemberJpaRepository.deleteAllByMemberId(memberId)
    }
}
