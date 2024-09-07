package com.bibbi.domain.model

data class MemberRealEmoji(
    val id: String,
    val memberId: String,
    val familyId: String,
    val type: Emoji,
    val realEmojiImageUrl: String,
    val realEmojiImageKey: String
) {
    companion object {
        fun newMemberRealEmoji(
            id: String,
            memberId: String,
            familyId: String,
            type: Emoji,
            realEmojiImageUrl: String,
            realEmojiImageKey: String
        ): MemberRealEmoji {
            return MemberRealEmoji(
                id = id,
                memberId = memberId,
                familyId = familyId,
                type = type,
                realEmojiImageUrl = realEmojiImageUrl,
                realEmojiImageKey = realEmojiImageKey
            )
        }
    }

    fun updateRealEmoji(newRealEmojiImageUrl: String, newRealEmojiImageKey: String): MemberRealEmoji {
        return this.copy(
            realEmojiImageUrl = newRealEmojiImageUrl,
            realEmojiImageKey = newRealEmojiImageKey
        )
    }
}
