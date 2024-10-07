package com.bibbi.domain.gateway

import com.bibbi.domain.model.MemberDevice

interface MemberDeviceGateway {

    fun save(memberDevice: MemberDevice): MemberDevice

    fun findById(memberId: String, fcmToken: String): MemberDevice?
    fun findAllByMemberId(memberId: String): List<MemberDevice>

    fun delete(memberDevice: MemberDevice)
    fun deleteAllByFcmToken(fcmToken: String)
    fun deleteAllByMemberId(memberId: String)
}
