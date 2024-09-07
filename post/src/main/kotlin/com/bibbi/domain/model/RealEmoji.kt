package com.bibbi.domain.model

data class RealEmoji(
    val id: String,
    val memberRealEmojiId: String,
    val postId: String,
    val memberId: String
) {
    companion object {
        fun newRealEmoji(
            id: String,
            memberRealEmojiId: String,
            postId: String,
            memberId: String
        ): RealEmoji {
            return RealEmoji(
                id = id,
                memberRealEmojiId = memberRealEmojiId,
                postId = postId,
                memberId = memberId
            )
        }
    }
}
