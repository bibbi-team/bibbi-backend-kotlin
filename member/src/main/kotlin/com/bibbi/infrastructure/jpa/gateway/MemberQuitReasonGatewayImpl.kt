package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.MemberQuitReasonGateway
import com.bibbi.domain.model.MemberQuitReason
import com.bibbi.infrastructure.jpa.entity.MemberQuitReasonEntity
import com.bibbi.infrastructure.jpa.entity.key.MemberQuitReasonEntityKey
import com.bibbi.infrastructure.jpa.repository.MemberQuitReasonJpaRepository
import org.springframework.stereotype.Component

@Component
class MemberQuitReasonGatewayImpl(
    private val memberQuitReasonJpaRepository: MemberQuitReasonJpaRepository
) : MemberQuitReasonGateway {

    override fun save(memberQuitReason: MemberQuitReason): MemberQuitReason {
        return memberQuitReasonJpaRepository
            .save(MemberQuitReasonEntity.fromDomain(memberQuitReason))
            .toDomain()
    }

    override fun findById(memberId: String, reasonId: String): MemberQuitReason? {
        return memberQuitReasonJpaRepository
            .findById(MemberQuitReasonEntityKey(memberId, reasonId))
            .orElse(null)
            ?.toDomain()
    }

    override fun delete(memberQuitReason: MemberQuitReason) {
        memberQuitReasonJpaRepository.delete(MemberQuitReasonEntity.fromDomain(memberQuitReason))
    }
}
