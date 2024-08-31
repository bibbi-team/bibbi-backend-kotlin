package com.bibbi.domain.entity

data class RealEmoji(
    val id: String,
    val realEmojiId: String,
    val postId: String,
    val memberId: String
) {
    companion object {
        fun newRealEmoji(
            id: String,
            realEmojiId: String,
            postId: String,
            memberId: String
        ): RealEmoji {
            return RealEmoji(
                id = id,
                realEmojiId = realEmojiId,
                postId = postId,
                memberId = memberId
            )
        }
    }
}
