package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.MemberRealEmojiGateway
import com.bibbi.domain.model.Emoji
import com.bibbi.domain.model.MemberRealEmoji
import com.bibbi.infrastructure.jpa.entity.MemberRealEmojiEntity
import com.bibbi.infrastructure.jpa.repository.MemberRealEmojiJpaRepository
import org.springframework.stereotype.Component

@Component
class MemberRealEmojiGatewayImpl(
    private val memberRealEmojiJpaRepository: MemberRealEmojiJpaRepository
) : MemberRealEmojiGateway {
    override fun save(memberRealEmoji: MemberRealEmoji): MemberRealEmoji {
        return memberRealEmojiJpaRepository
            .save(MemberRealEmojiEntity.fromDomain(memberRealEmoji))
            .toDomain()
    }

    override fun findByTypeAndMemberIdAndFamilyId(type: Emoji, memberId: String, familyId: String): MemberRealEmoji? {
        return memberRealEmojiJpaRepository
            .findByTypeAndMemberIdAndFamilyId(type, memberId, familyId)
            ?.toDomain()
    }

    override fun findByIdAndFamilyId(id: String, familyId: String): MemberRealEmoji? {
        return memberRealEmojiJpaRepository
            .findByIdAndFamilyId(id, familyId)
            ?.toDomain()
    }

    override fun findAllByMemberIdAndFamilyId(memberId: String, familyId: String): List<MemberRealEmoji> {
        return memberRealEmojiJpaRepository
            .findAllByMemberIdAndFamilyId(memberId, familyId)
            .map { it.toDomain() }
            .toList()
    }
}
