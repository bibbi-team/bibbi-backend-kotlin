package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.MemberPickGateway
import com.bibbi.domain.model.MemberPick
import com.bibbi.infrastructure.jpa.entity.MemberPickEntity
import com.bibbi.infrastructure.jpa.repository.MemberPickJpaRepository
import org.springframework.stereotype.Component
import java.time.LocalDate

@Component
class MemberPickGatewayImpl(
    private val memberPickJpaRepository: MemberPickJpaRepository
) : MemberPickGateway {

    override fun save(memberPick: MemberPick): MemberPick {
        return memberPickJpaRepository
            .save(MemberPickEntity.fromDomain(memberPick))
            .toDomain()
    }

    override fun findById(pickId: String): MemberPick? {
        return memberPickJpaRepository
            .findById(pickId)
            .orElse(null)
            ?.toDomain()
    }

    override fun findByFamilyIdAndFromMemberIdAndDateAndToMemberId(
        familyId: String,
        fromMemberId: String,
        date: LocalDate,
        toMemberId: String
    ): MemberPick? {
        return memberPickJpaRepository
            .findByFamilyIdAndFromMemberIdAndDateAndToMemberId(familyId, fromMemberId, date, toMemberId)
            ?.toDomain()
    }

    override fun findAllByFamilyIdAndDateAndToMemberId(
        familyId: String,
        date: LocalDate,
        toMemberId: String
    ): List<MemberPick> {
        return memberPickJpaRepository
            .findAllByFamilyIdAndDateAndToMemberId(familyId, date, toMemberId)
            .map { it.toDomain() }
    }

    override fun findAllByFamilyIdAndDateAndFromMemberId(
        familyId: String,
        date: LocalDate,
        fromMemberId: String
    ): List<MemberPick> {
        return memberPickJpaRepository
            .findAllByFamilyIdAndDateAndFromMemberId(familyId, date, fromMemberId)
            .map { it.toDomain() }
    }

    override fun delete(pickId: String) {
        memberPickJpaRepository.deleteById(pickId)
    }
}