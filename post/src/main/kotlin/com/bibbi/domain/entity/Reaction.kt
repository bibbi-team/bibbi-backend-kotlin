package com.bibbi.domain.entity

data class Reaction(
    val id: String,
    val postId: String,
    val memberId: String,
    val emoji: Emoji
) {
    companion object {
        fun newReaction(
            id: String,
            postId: String,
            memberId: String,
            emoji: Emoji
        ): Reaction {
            return Reaction(
                id = id,
                postId = postId,
                memberId = memberId,
                emoji = emoji
            )
        }
    }
}
