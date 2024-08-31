package com.bibbi.domain.entity

data class Post(
    val id: String,
    val memberId: String,
    val familyId: String,
    val missionId: String? = null,
    val type: PostType,
    val postImgUrl: String,
    val postImgKey: String,
    val content: String?,
    val commentCnt: Int = 0,
    val reactionCnt: Int = 0,
    val realEmojiCnt: Int = 0,
    val comments: List<Comment> = listOf(),
    val reactions: List<Reaction> = listOf(),
    val realEmojis: List<RealEmoji> = listOf()
) {
    init {
        validateContent(content)
    }

    companion object {
        fun newPost(
            id: String,
            memberId: String,
            familyId: String,
            type: PostType,
            postImgUrl: String,
            postImgKey: String,
            content: String? = null,
            missionId: String? = null
        ): Post {
            return Post(
                id = id,
                memberId = memberId,
                familyId = familyId,
                missionId = missionId,
                type = type,
                postImgUrl = postImgUrl,
                postImgKey = postImgKey,
                content = content
            )
        }

        private fun validateContent(content: String?) {
            content?.let {
                if (it.codePoints().count() > 8 || it.contains(" ")) {
                    throw IllegalArgumentException("Content is invalid")
                }
            }
        }
    }

    fun addReaction(reaction: Reaction): Post {
        val updatedReactions = reactions + reaction
        return this.copy(reactions = updatedReactions, reactionCnt = updatedReactions.size)
    }

    fun removeReaction(reaction: Reaction): Post {
        val updatedReactions = reactions - reaction
        return this.copy(reactions = updatedReactions, reactionCnt = updatedReactions.size)
    }

    fun addRealEmoji(realEmoji: RealEmoji): Post {
        val updatedRealEmojis = realEmojis + realEmoji
        return this.copy(realEmojis = updatedRealEmojis, realEmojiCnt = updatedRealEmojis.size)
    }

    fun removeRealEmoji(realEmoji: RealEmoji): Post {
        val updatedRealEmojis = realEmojis - realEmoji
        return this.copy(realEmojis = updatedRealEmojis, realEmojiCnt = updatedRealEmojis.size)
    }

    fun addComment(comment: Comment): Post {
        val updatedComments = comments + comment
        return this.copy(comments = updatedComments, commentCnt = updatedComments.size)
    }

    fun removeComment(comment: Comment): Post {
        val updatedComments = comments - comment
        return this.copy(comments = updatedComments, commentCnt = updatedComments.size)
    }
}
