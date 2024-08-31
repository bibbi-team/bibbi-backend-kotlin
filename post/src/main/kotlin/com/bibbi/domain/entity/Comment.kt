package com.bibbi.domain.entity

data class Comment(
    val id: String,
    val postId: String,
    val memberId: String,
    val content: String
) {
    companion object {
        fun newComment(
            id: String,
            postId: String,
            memberId: String,
            content: String
        ): Comment {
            return Comment(
                id = id,
                postId = postId,
                memberId = memberId,
                content = content
            )
        }
    }

    fun updateContent(newContent: String): Comment {
        return this.copy(content = newContent)
    }
}
