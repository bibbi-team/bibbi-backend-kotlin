package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.RealEmojiGateway
import com.bibbi.domain.model.RealEmoji
import com.bibbi.infrastructure.jpa.entity.RealEmojiEntity
import com.bibbi.infrastructure.jpa.repository.RealEmojiJpaRepository
import org.springframework.stereotype.Component

@Component
class RealEmojiGatewayImpl(
    private val realEmojiJpaRepository: RealEmojiJpaRepository
) : RealEmojiGateway {
    override fun save(realEmoji: RealEmoji) : RealEmoji {
        return realEmojiJpaRepository
            .save(RealEmojiEntity.fromDomain(realEmoji))
            .toDomain()
    }

    override fun delete(realEmoji: RealEmoji) {
        realEmojiJpaRepository.delete(RealEmojiEntity.fromDomain(realEmoji))
    }

    override fun existsByPostIdAndMemberIdAndMemberRealEmojiId(
        postId: String,
        memberId: String,
        memberRealEmojiId: String
    ): Boolean {
        return realEmojiJpaRepository.existsByPostIdAndMemberIdAndMemberRealEmojiId(postId, memberId, memberRealEmojiId)
    }
}
