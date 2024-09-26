package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.CommentGateway
import com.bibbi.domain.model.Comment
import com.bibbi.infrastructure.jpa.entity.CommentEntity
import com.bibbi.infrastructure.jpa.repository.CommentJpaRepository
import org.springframework.stereotype.Component

@Component
class CommentGatewayImpl(
    private val commentJpaRepository: CommentJpaRepository
) : CommentGateway {
    override fun save(comment: Comment): Comment {
        return commentJpaRepository
            .save(CommentEntity.fromDomain(comment))
            .toDomain()
    }

    override fun delete(comment: Comment) {
        commentJpaRepository.delete(CommentEntity.fromDomain(comment))
    }

    override fun findById(commentId: String): Comment? {
        return commentJpaRepository
            .findById(commentId)
            .orElse(null)
            ?.toDomain()
    }
}
