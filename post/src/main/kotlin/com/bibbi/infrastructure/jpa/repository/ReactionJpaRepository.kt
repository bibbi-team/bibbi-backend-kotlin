package com.bibbi.infrastructure.jpa.repository

import com.bibbi.domain.model.Emoji
import com.bibbi.infrastructure.jpa.entity.ReactionEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ReactionJpaRepository : JpaRepository<ReactionEntity, String> {
    fun findAllByPostId(postId: String): List<ReactionEntity>
    fun findByPostIdAndMemberIdAndEmoji(postId: String, memberId: String, emoji: Emoji): ReactionEntity?
}
