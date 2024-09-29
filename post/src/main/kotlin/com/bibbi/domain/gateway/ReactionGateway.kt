package com.bibbi.domain.gateway

import com.bibbi.domain.model.Emoji
import com.bibbi.domain.model.Reaction

interface ReactionGateway {
    fun save(reaction: Reaction): Reaction
    fun findAllByPostId(postId: String): List<Reaction>
    fun deleteById(reactionId: String)
    fun findReactionByPostIdAndMemberIdAndEmoji(postId: String, memberId: String, emoji: Emoji): Reaction?
}
