package com.bibbi.infrastructure.jpa.entity

import com.bibbi.infrastructure.jpa.entity.BaseEntity
import com.bibbi.domain.model.RealEmoji
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

    @Column(name = "member_real_emoji_id", nullable = false)
    val memberRealEmojiId: String,

    @Column(name = "post_id", nullable = false)
    val postId: String,

    @Column(name = "member_id", columnDefinition = "CHAR(26)", nullable = false)
    val memberId: String
) : BaseEntity() {

    fun toDomain() = RealEmoji(
        id = id,
        memberRealEmojiId = memberRealEmojiId,
        postId = postId,
        memberId = memberId
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as RealEmojiEntity

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    companion object {
        fun fromDomain(realEmoji: RealEmoji) = with(realEmoji) {
            RealEmojiEntity(
                id = id,
                memberRealEmojiId = memberRealEmojiId,
                postId = postId,
                memberId = memberId
            )
        }
    }
}
