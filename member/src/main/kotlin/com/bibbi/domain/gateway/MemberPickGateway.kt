package com.bibbi.domain.gateway

import com.bibbi.domain.model.MemberPick
import java.time.LocalDate

interface MemberPickGateway {

    fun save(memberPick: MemberPick): MemberPick

    fun findById(pickId: String): MemberPick?

    fun findByFamilyIdAndFromMemberIdAndDateAndToMemberId(
        familyId: String,
        fromMemberId: String,
        date: LocalDate,
        toMemberId: String
    ): MemberPick?

    fun findAllByFamilyIdAndDateAndToMemberId(
        familyId: String,
        date: LocalDate,
        toMemberId: String
    ): List<MemberPick>

    fun findAllByFamilyIdAndDateAndFromMemberId(
        familyId: String,
        date: LocalDate,
        fromMemberId: String
    ): List<MemberPick>

    fun delete(pickId: String)
}