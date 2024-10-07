package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.SocialMemberEntity
import com.bibbi.infrastructure.jpa.entity.key.SocialMemberEntityKey
import org.springframework.data.jpa.repository.JpaRepository

interface SocialMemberJpaRepository : JpaRepository<SocialMemberEntity, SocialMemberEntityKey> {

    fun deleteAllByMemberId(memberId: String?)
}