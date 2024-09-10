package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.SocialLoginProvider
import com.bibbi.infrastructure.jpa.entity.key.SocialMemberEntityKey
import jakarta.persistence.*

@Entity(name = "social_members")
@Table(indexes = [
    Index(name = "social_member_idx1", columnList = "member_id"),
])
@IdClass(SocialMemberEntityKey::class)
class SocialMember (

    @Id
    @Column(name = "provider")
    @Enumerated(EnumType.STRING)
    val provider : SocialLoginProvider,

    @Id
    @Column(name = "identifier")
    val identifier : String,

    @Column(name = "member_id", columnDefinition = "CHAR(26)", nullable = false)
    val memberId : String,

) : BaseEntity()
