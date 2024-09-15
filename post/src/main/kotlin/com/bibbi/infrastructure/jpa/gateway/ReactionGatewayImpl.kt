package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.ReactionGateway
import com.bibbi.domain.model.Emoji
import com.bibbi.domain.model.Reaction
import com.bibbi.infrastructure.jpa.entity.ReactionEntity
import com.bibbi.infrastructure.jpa.repository.JpaReactionRepository
import org.springframework.stereotype.Component

@Component
class ReactionGatewayImpl(
    private val jpaReactionRepository: JpaReactionRepository
) : ReactionGateway {
    override fun save(reaction: Reaction): Reaction {
        return jpaReactionRepository
            .save(ReactionEntity.fromDomain(reaction))
            .toDomain()
    }

    override fun findAllByPostId(postId: String): List<Reaction> {
        return jpaReactionRepository
            .findAllByPostId(postId)
            .map(ReactionEntity::toDomain)
            .toList()
    }

    override fun deleteById(reactionId: String) {
        jpaReactionRepository.deleteById(reactionId)
    }

    override fun findReactionByPostIdAndMemberIdAndEmoji(postId: String, memberId: String, emoji: Emoji): Reaction? {
        return jpaReactionRepository
            .findByPostIdAndMemberIdAndEmoji(postId, memberId, emoji)
            ?.toDomain()
    }
}
