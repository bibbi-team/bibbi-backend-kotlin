package com.bibbi.domain.gateway

import com.bibbi.domain.model.RealEmoji

interface RealEmojiGateway {
    fun save(realEmoji: RealEmoji): RealEmoji
    fun delete(realEmoji: RealEmoji)
    fun existsByPostIdAndMemberIdAndMemberRealEmojiId(postId: String, memberId: String, memberRealEmojiId: String): Boolean
}
