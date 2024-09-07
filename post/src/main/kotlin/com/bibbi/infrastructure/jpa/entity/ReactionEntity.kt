package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.BaseEntity
import com.bibbi.domain.entity.Emoji
import com.bibbi.domain.entity.Reaction
import jakarta.persistence.*

@Entity(name = "reaction")
@Table(indexes = [
    Index(name = "reaction_idx1", columnList = "post_id"),
    Index(name = "reaction_idx2", columnList = "member_id")
])
class ReactionEntity private constructor(
    @Id
    @Column(name = "reaction_id", columnDefinition = "CHAR(26)", nullable = false)
    val id: String,

    @Column(name = "post_id", nullable = false)
    val postId: String,

    @Column(name = "member_id", columnDefinition = "CHAR(26)", nullable = false)
    val memberId: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "emoji", nullable = false)
    val emoji: Emoji
) : BaseEntity() {

    fun toDomain() = Reaction(
        id = id,
        postId = postId,
        memberId = memberId,
        emoji = emoji
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
        fun fromDomain(reaction: Reaction) = with(reaction) {
            ReactionEntity(
                id = id,
                postId = postId,
                memberId = memberId,
                emoji = emoji
            )
        }
    }
}
