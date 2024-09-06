package com.bibbi.domain.model

import java.time.LocalDateTime

data class Family(
    val familyId: String,
    var score: Int,
    val createdAt: LocalDateTime?,
    val updatedAt: LocalDateTime?,
) {
    fun addNewPostScore() { addScore(NEW_POST_SCORE) }
    fun subtractNewPostScore() { subtractScore(NEW_POST_SCORE) }

    fun addAllFamilyMembersPostsUploadedScore() { addScore(ALL_FAMILY_MEMBERS_POSTS_UPLOADED_SCORE) }
    fun subtractAllFamilyMembersPostsUploadedScore() { subtractScore(ALL_FAMILY_MEMBERS_POSTS_UPLOADED_SCORE) }

    fun addNewCommentScore() { addScore(NEW_COMMENT_SCORE) }
    fun subtractNewCommentScore() { subtractScore(NEW_COMMENT_SCORE) }

    fun addNewReactionScore() { addScore(NEW_REACTION_SCORE) }
    fun subtractNewReactionScore() { subtractScore(NEW_REACTION_SCORE) }

    fun addNewRealEmojiScore() { addScore(NEW_REAL_EMOJI_SCORE) }
    fun subtractNewRealEmojiScore() { subtractScore(NEW_REAL_EMOJI_SCORE) }

    fun addScore(score : Int) { this.score += score }
    fun subtractScore(score : Int) { this.score -= score }
    fun resetScore() { this.score = 0 }

    companion object {
        const val NEW_POST_SCORE = 20
        const val ALL_FAMILY_MEMBERS_POSTS_UPLOADED_SCORE = 50
        const val NEW_COMMENT_SCORE = 5
        const val NEW_REACTION_SCORE = 1
        const val NEW_REAL_EMOJI_SCORE = 3
    }
}