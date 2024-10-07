package com.bibbi.domain.gateway

import com.bibbi.domain.model.Member
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import java.time.LocalDateTime

interface MemberGateway {

    fun save(member: Member): Member

    fun findById(memberId: String): Member?
    fun findAllByFamilyIdAndDeletedAtIsNull(familyId: String): List<Member>
    fun findAllByFamilyIdAndDeletedAtIsNull(familyId: String, pageRequest: PageRequest): Page<Member>
    fun findAllByFamilyIdAndFamilyJoinAtBeforeAndDeletedAtIsNull(familyId: String, familyJoinAt: LocalDateTime): List<Member>
    fun findAllByDeletedAtIsNull(): List<Member>
    fun existsByIdAndDeletedAtIsNotNull(memberId: String): Boolean

    fun deleteById(memberId: String)
}
