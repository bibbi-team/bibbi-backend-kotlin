package com.bibbi.domain.gateway

import com.bibbi.domain.model.Emoji
import com.bibbi.domain.model.MemberRealEmoji

interface MemberRealEmojiGateway {
    fun save(memberRealEmoji: MemberRealEmoji): MemberRealEmoji
    fun findByTypeAndMemberIdAndFamilyId(type: Emoji, memberId: String, familyId: String): MemberRealEmoji?
    fun findByIdAndFamilyId(id: String, familyId: String): MemberRealEmoji?
    fun findAllByMemberIdAndFamilyId(memberId: String, familyId: String): List<MemberRealEmoji>
}
