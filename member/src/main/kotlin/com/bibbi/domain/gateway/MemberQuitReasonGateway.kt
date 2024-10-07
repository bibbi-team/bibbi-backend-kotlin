package com.bibbi.domain.gateway

import com.bibbi.domain.model.MemberQuitReason

interface MemberQuitReasonGateway {

    fun save(memberQuitReason: MemberQuitReason): MemberQuitReason

    fun findById(memberId: String, reasonId: String): MemberQuitReason?

    fun delete(memberQuitReason: MemberQuitReason)
}
