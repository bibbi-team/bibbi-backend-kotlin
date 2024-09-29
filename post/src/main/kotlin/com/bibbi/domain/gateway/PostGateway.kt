package com.bibbi.domain.gateway

import com.bibbi.domain.model.Post
import java.time.LocalDateTime

interface PostGateway {
    fun findById(postId: String): Post?
    fun save(post: Post): Post
    fun findAllByFamilyIdAndCreatedAtBetween(familyId: String, start: LocalDateTime, end: LocalDateTime): List<Post>
}
