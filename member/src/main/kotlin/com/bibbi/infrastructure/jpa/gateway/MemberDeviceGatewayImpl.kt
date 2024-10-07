package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.MemberDeviceGateway
import com.bibbi.domain.model.MemberDevice
import com.bibbi.infrastructure.jpa.entity.MemberDeviceEntity
import com.bibbi.infrastructure.jpa.entity.key.MemberDeviceEntityKey
import com.bibbi.infrastructure.jpa.repository.MemberDeviceJpaRepository
import org.springframework.stereotype.Component

@Component
class MemberDeviceGatewayImpl(
    private val memberDeviceJpaRepository: MemberDeviceJpaRepository
) : MemberDeviceGateway {

    override fun save(memberDevice: MemberDevice): MemberDevice {
        return memberDeviceJpaRepository
            .save(MemberDeviceEntity.fromDomain(memberDevice))
            .toDomain()
    }

    override fun findById(memberId: String, fcmToken: String): MemberDevice? {
        return memberDeviceJpaRepository
            .findById(MemberDeviceEntityKey(memberId, fcmToken))
            .orElse(null)
            ?.toDomain()
    }

    override fun findAllByMemberId(memberId: String): List<MemberDevice> {
        return memberDeviceJpaRepository
            .findAllByMemberId(memberId)
            .map { it.toDomain() }
    }

    override fun delete(memberDevice: MemberDevice) {
        memberDeviceJpaRepository.delete(MemberDeviceEntity.fromDomain(memberDevice))
    }

    override fun deleteAllByFcmToken(fcmToken: String) {
        memberDeviceJpaRepository.deleteAllByFcmToken(fcmToken)
    }

    override fun deleteAllByMemberId(memberId: String) {
        memberDeviceJpaRepository.deleteAllByMemberId(memberId)
    }

}
