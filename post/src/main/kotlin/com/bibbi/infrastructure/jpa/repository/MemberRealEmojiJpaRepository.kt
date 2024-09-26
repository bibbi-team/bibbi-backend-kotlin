package com.bibbi.infrastructure.jpa.repository

import com.bibbi.domain.model.Emoji
import com.bibbi.infrastructure.jpa.entity.MemberRealEmojiEntity
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRealEmojiJpaRepository : JpaRepository<MemberRealEmojiEntity, String> {
    fun findByTypeAndMemberIdAndFamilyId(type: Emoji, memberId: String, familyId: String): MemberRealEmojiEntity?
    fun findByIdAndFamilyId(id: String, familyId: String): MemberRealEmojiEntity?
    fun findAllByMemberIdAndFamilyId(memberId: String, familyId: String): List<MemberRealEmojiEntity>
}
