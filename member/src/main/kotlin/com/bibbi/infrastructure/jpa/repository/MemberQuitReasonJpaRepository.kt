package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.MemberQuitReasonEntity
import com.bibbi.infrastructure.jpa.entity.key.MemberQuitReasonEntityKey
import org.springframework.data.jpa.repository.JpaRepository

interface MemberQuitReasonJpaRepository : JpaRepository<MemberQuitReasonEntity, MemberQuitReasonEntityKey> {
}