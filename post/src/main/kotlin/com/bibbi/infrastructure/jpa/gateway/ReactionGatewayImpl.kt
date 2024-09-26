package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.ReactionGateway
import com.bibbi.domain.model.Emoji
import com.bibbi.domain.model.Reaction
import com.bibbi.infrastructure.jpa.entity.ReactionEntity
import com.bibbi.infrastructure.jpa.repository.ReactionJpaRepository
import org.springframework.stereotype.Component

@Component
class ReactionGatewayImpl(
    private val reactionJpaRepository: ReactionJpaRepository
) : ReactionGateway {
    override fun save(reaction: Reaction): Reaction {
        return reactionJpaRepository
            .save(ReactionEntity.fromDomain(reaction))
            .toDomain()
    }

    override fun findAllByPostId(postId: String): List<Reaction> {
        return reactionJpaRepository
            .findAllByPostId(postId)
            .map(ReactionEntity::toDomain)
            .toList()
    }

    override fun deleteById(reactionId: String) {
        reactionJpaRepository.deleteById(reactionId)
    }

    override fun findReactionByPostIdAndMemberIdAndEmoji(postId: String, memberId: String, emoji: Emoji): Reaction? {
        return reactionJpaRepository
            .findByPostIdAndMemberIdAndEmoji(postId, memberId, emoji)
            ?.toDomain()
    }
}
