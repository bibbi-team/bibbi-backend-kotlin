package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.PostGateway
import com.bibbi.domain.model.Post
import com.bibbi.infrastructure.jpa.entity.PostEntity
import com.bibbi.infrastructure.jpa.repository.JpaPostRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class PostGatewayImpl(
    private val jpaPostRepository: JpaPostRepository
) : PostGateway {
    override fun save(post: Post): Post {
        return jpaPostRepository
            .save(PostEntity.fromDomain(post))
            .toDomain()
    }

    override fun findById(postId: String): Post? {
        return jpaPostRepository
            .findById(postId)
            .orElse(null)
            ?.toDomain()
    }

    override fun findAllByFamilyIdAndCreatedAtBetween(
        familyId: String,
        start: LocalDateTime,
        end: LocalDateTime
    ): List<Post> {
        return jpaPostRepository
            .findAllByFamilyIdAndCreatedAtBetween(familyId, start, end)
            .map(PostEntity::toDomain)
            .toList()
    }
}
