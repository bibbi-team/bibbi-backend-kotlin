package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.Emoji
import com.bibbi.domain.model.MemberRealEmoji
import jakarta.persistence.*
import lombok.*

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@Getter
@Entity(name = "member_real_emoji")
@Table(indexes = [
    Index(name = "member_real_emoji_idx1", columnList = "member_id")
])
class MemberRealEmojiEntity private constructor(
    @Id
    @Column(name = "member_real_emoji_id", columnDefinition = "CHAR(26)", nullable = false)
    val id: String,

    @Column(name = "member_id", columnDefinition = "CHAR(26)", nullable = false)
    val memberId: String,

    @Column(name = "family_id", columnDefinition = "CHAR(26)", nullable = false)
    val familyId: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    val type: Emoji,

    @Column(name = "real_emoji_image_url", nullable = false)
    var realEmojiImageUrl: String,

    @Column(name = "real_emoji_image_key", nullable = false)
    var realEmojiImageKey: String
) : BaseEntity() {

    fun toDomain() = MemberRealEmoji(
        id = id,
        memberId = memberId,
        familyId = familyId,
        type = type,
        realEmojiImageUrl = realEmojiImageUrl,
        realEmojiImageKey = realEmojiImageKey
    )

    fun updateRealEmoji(newRealEmojiImageUrl: String, newRealEmojiImageKey: String): MemberRealEmojiEntity {
        this.realEmojiImageUrl = newRealEmojiImageUrl
        this.realEmojiImageKey = newRealEmojiImageKey
        return this
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as MemberRealEmojiEntity

        return id == other.id
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    companion object {
        fun fromDomain(memberRealEmoji: MemberRealEmoji) = with(memberRealEmoji) {
            MemberRealEmojiEntity(
                id = id,
                memberId = memberId,
                familyId = familyId,
                type = type,
                realEmojiImageUrl = realEmojiImageUrl,
                realEmojiImageKey = realEmojiImageKey
            )
        }
    }
}
