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
    val realEmojiCnt: Int = 0
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
                    // 임시 예외 처리
                    throw IllegalArgumentException("Content is invalid")
                }
            }
        }
    }
}
