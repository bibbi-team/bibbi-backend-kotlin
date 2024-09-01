package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.entity.Comment
import jakarta.persistence.*
import lombok.*

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Getter
@Entity(name = "comment")
@Table(indexes = [
    Index(name = "comment_idx1", columnList = "post_id"),
    Index(name = "comment_idx2", columnList = "member_id")
])
class CommentEntity private constructor(
    @Id
    @Column(name = "comment_id", columnDefinition = "CHAR(26)", nullable = false)
    val id: String,

    @Column(name = "post_id", nullable = false)
    val postId: String,

    @Column(name = "member_id", columnDefinition = "CHAR(26)", nullable = false)
    val memberId: String,

    @Column(name = "content", nullable = false)
    var content: String
) {
    fun toDomain() = Comment(
        id = id,
        postId = postId,
        memberId = memberId,
        content = content
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CommentEntity

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    companion object {
        fun fromDomain(comment: Comment) = with(comment) {
            CommentEntity(
                id = id,
                postId = postId,
                memberId = memberId,
                content = content
            )
        }
    }
}
