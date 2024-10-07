package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.MemberDeviceEntity
import com.bibbi.infrastructure.jpa.entity.key.MemberDeviceEntityKey
import org.springframework.data.jpa.repository.JpaRepository

interface MemberDeviceJpaRepository : JpaRepository<MemberDeviceEntity, MemberDeviceEntityKey> {

    fun findAllByMemberId(memberId: String): List<MemberDeviceEntity>
    fun deleteAllByFcmToken(fcmToken: String)
    fun deleteAllByMemberId(memberId: String)
}
