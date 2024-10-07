package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.MemberDevice
import com.bibbi.infrastructure.jpa.entity.key.MemberDeviceEntityKey
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass

@Entity(name = "member_device")
@IdClass(MemberDeviceEntityKey::class)
class MemberDeviceEntity (

    @Id
    @Column(name = "member_id", length = 26, columnDefinition = "CHAR(26)")
    val memberId : String,

    @Id
    @Column(name = "fcm_token", length = 255, columnDefinition = "VARCHAR(255)")
    val fcmToken : String,

) : BaseEntity() {

    companion object {
        fun fromDomain(memberDevice: MemberDevice) = with(memberDevice) {
            MemberDeviceEntity(
                memberId = memberId,
                fcmToken = fcmToken,
            )
        }
    }

    fun toDomain() = MemberDevice (
        memberId = memberId,
        fcmToken = fcmToken,
    )
}
