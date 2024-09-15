package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.RealEmojiEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaRealEmojiRepository : JpaRepository<RealEmojiEntity, String> {
    fun existsByPostIdAndMemberIdAndMemberRealEmojiId(postId: String, memberId: String, memberRealEmojiId: String): Boolean
}
