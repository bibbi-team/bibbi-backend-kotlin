package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.entity.RealEmoji
import jakarta.persistence.*

@Entity(name = "real_emoji")
@Table(indexes = [
    Index(name = "real_emoji_idx1", columnList = "post_id"),
    Index(name = "real_emoji_idx2", columnList = "member_id")
])
class RealEmojiEntity private constructor(
    @Id
    @Column(name = "real_emoji_id", columnDefinition = "CHAR(26)", nullable = false)
    val id: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_real_emoji_id", nullable = false)
    val realEmoji: MemberRealEmojiEntity,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)
    val post: PostEntity,

    @Column(name = "member_id", columnDefinition = "CHAR(26)", nullable = false)
    val memberId: String
) {
    fun toDomain() = RealEmoji(
        id = id,
        realEmojiId = realEmoji.id,
        postId = post.id,
        memberId = memberId
    )

    companion object {
        fun fromDomain(realEmoji: RealEmoji, memberRealEmoji: MemberRealEmojiEntity, post: PostEntity) = RealEmojiEntity(
            id = realEmoji.id,
            realEmoji = memberRealEmoji,
            post = post,
            memberId = realEmoji.memberId
        )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RealEmojiEntity

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
