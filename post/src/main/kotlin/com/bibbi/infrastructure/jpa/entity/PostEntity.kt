package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.Post
import com.bibbi.domain.model.PostType
import jakarta.persistence.*
import lombok.*

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Getter
@Entity(name = "post")
@Table(indexes = [
    Index(name = "post_idx1", columnList = "member_id")
])
class PostEntity private constructor(
    @Id
    @Column(name = "post_id", columnDefinition = "CHAR(26)", nullable = false)
    val id: String,

    @Column(name = "member_id", columnDefinition = "CHAR(26)", nullable = false)
    val memberId: String,

    @Column(name = "family_id", columnDefinition = "CHAR(26)", nullable = false)
    val familyId: String,

    @Column(name = "mission_id", columnDefinition = "CHAR(26)")
    val missionId: String? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    val type: PostType,

    @Column(name = "post_img_url", nullable = false)
    val postImgUrl: String,

    @Column(name = "post_img_key", nullable = false)
    val postImgKey: String,

    @Column(name = "content")
    val content: String?,

    @Column(name = "comment_cnt", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    var commentCnt: Int = 0,

    @Column(name = "reaction_cnt", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    var reactionCnt: Int = 0,

    @Column(name = "real_emoji_cnt", nullable = false, columnDefinition = "INTEGER DEFAULT 0")
    var realEmojiCnt: Int = 0
) : BaseEntity() {

    fun toDomain() = Post(
        id = id,
        memberId = memberId,
        familyId = familyId,
        missionId = missionId,
        type = type,
        postImgUrl = postImgUrl,
        postImgKey = postImgKey,
        content = content,
        commentCnt = commentCnt,
        reactionCnt = reactionCnt,
        realEmojiCnt = realEmojiCnt
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ReactionEntity

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    companion object {
        fun fromDomain(post: Post): PostEntity {
            val postEntity = PostEntity(
                id = post.id,
                memberId = post.memberId,
                familyId = post.familyId,
                missionId = post.missionId,
                type = post.type,
                postImgUrl = post.postImgUrl,
                postImgKey = post.postImgKey,
                content = post.content,
                commentCnt = post.commentCnt,
                reactionCnt = post.reactionCnt,
                realEmojiCnt = post.realEmojiCnt
            )

            return postEntity
        }
    }
}
