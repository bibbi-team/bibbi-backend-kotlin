package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.MemberRealEmojiGateway
import com.bibbi.domain.model.Emoji
import com.bibbi.domain.model.MemberRealEmoji
import com.bibbi.infrastructure.jpa.entity.MemberRealEmojiEntity
import com.bibbi.infrastructure.jpa.repository.JpaMemberRealEmojiRepository
import org.springframework.stereotype.Component

@Component
class MemberRealEmojiGatewayImpl(
    private val jpaMemberRealEmojiRepository: JpaMemberRealEmojiRepository
) : MemberRealEmojiGateway {
    override fun save(memberRealEmoji: MemberRealEmoji): MemberRealEmoji {
        return jpaMemberRealEmojiRepository
            .save(MemberRealEmojiEntity.fromDomain(memberRealEmoji))
            .toDomain()
    }

    override fun findByTypeAndMemberIdAndFamilyId(type: Emoji, memberId: String, familyId: String): MemberRealEmoji? {
        return jpaMemberRealEmojiRepository
            .findByTypeAndMemberIdAndFamilyId(type, memberId, familyId)
            ?.toDomain()
    }

    override fun findByIdAndFamilyId(id: String, familyId: String): MemberRealEmoji? {
        return jpaMemberRealEmojiRepository
            .findByIdAndFamilyId(id, familyId)
            ?.toDomain()
    }

    override fun findAllByMemberIdAndFamilyId(memberId: String, familyId: String): List<MemberRealEmoji> {
        return jpaMemberRealEmojiRepository
            .findAllByMemberIdAndFamilyId(memberId, familyId)
            .map(MemberRealEmojiEntity::toDomain)
            .toList()
    }
}
