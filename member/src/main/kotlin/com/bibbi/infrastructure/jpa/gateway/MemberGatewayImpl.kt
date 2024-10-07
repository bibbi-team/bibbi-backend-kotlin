package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.MemberGateway
import com.bibbi.domain.model.Member
import com.bibbi.infrastructure.jpa.entity.MemberEntity
import com.bibbi.infrastructure.jpa.repository.MemberJpaRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class MemberGatewayImpl(
    private val memberJpaRepository: MemberJpaRepository
) : MemberGateway {

    override fun save(member: Member): Member {
        return memberJpaRepository
            .save(MemberEntity.fromDomain(member))
            .toDomain()
    }

    override fun findById(memberId: String): Member? {
        return memberJpaRepository
            .findById(memberId)
            .orElse(null)
            ?.toDomain()
    }

    override fun findAllByFamilyIdAndDeletedAtIsNull(familyId: String): List<Member> {
        return memberJpaRepository
            .findAllByFamilyIdAndDeletedAtIsNull(familyId)
            .map { it.toDomain() }
    }

    override fun findAllByFamilyIdAndDeletedAtIsNull(familyId: String, pageRequest: PageRequest): Page<Member> {
        return memberJpaRepository
            .findAllByFamilyIdAndDeletedAtIsNull(familyId, pageRequest)
            .map { it.toDomain() }
    }

    override fun findAllByFamilyIdAndFamilyJoinAtBeforeAndDeletedAtIsNull(
        familyId: String,
        familyJoinAt: LocalDateTime
    ): List<Member> {
        return memberJpaRepository
            .findAllByFamilyIdAndFamilyJoinAtBeforeAndDeletedAtIsNull(familyId, familyJoinAt)
            .map { it.toDomain() }
    }

    override fun findAllByDeletedAtIsNull(): List<Member> {
        return memberJpaRepository
            .findAllByDeletedAtIsNull()
            .map { it.toDomain() }
    }

    override fun existsByIdAndDeletedAtIsNotNull(memberId: String): Boolean {
        return memberJpaRepository.existsByIdAndDeletedAtIsNotNull(memberId)
    }

    override fun deleteById(memberId: String) {
        memberJpaRepository.deleteById(memberId)
    }
}
