package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.PostGateway
import com.bibbi.domain.model.Post
import com.bibbi.infrastructure.jpa.entity.PostEntity
import com.bibbi.infrastructure.jpa.repository.PostJpaRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class PostGatewayImpl(
    private val postJpaRepository: PostJpaRepository
) : PostGateway {
    override fun save(post: Post): Post {
        return postJpaRepository
            .save(PostEntity.fromDomain(post))
            .toDomain()
    }

    override fun findById(postId: String): Post? {
        return postJpaRepository
            .findById(postId)
            .orElse(null)
            ?.toDomain()
    }

    override fun findAllByFamilyIdAndCreatedAtBetween(
        familyId: String,
        start: LocalDateTime,
        end: LocalDateTime
    ): List<Post> {
        return postJpaRepository
            .findAllByFamilyIdAndCreatedAtBetween(familyId, start, end)
            .map(PostEntity::toDomain)
            .toList()
    }
}
