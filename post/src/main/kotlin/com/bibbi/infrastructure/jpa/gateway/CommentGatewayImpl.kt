package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.CommentGateway
import com.bibbi.domain.model.Comment
import com.bibbi.infrastructure.jpa.entity.CommentEntity
import com.bibbi.infrastructure.jpa.repository.JpaCommentRepository
import org.springframework.stereotype.Component

@Component
class CommentGatewayImpl(
    private val jpaCommentRepository: JpaCommentRepository
) : CommentGateway {
    override fun save(comment: Comment): Comment {
        return jpaCommentRepository
            .save(CommentEntity.fromDomain(comment))
            .toDomain()
    }

    override fun delete(comment: Comment) {
        jpaCommentRepository.delete(CommentEntity.fromDomain(comment))
    }

    override fun findById(commentId: String): Comment? {
        return jpaCommentRepository
            .findById(commentId)
            .orElse(null)
            ?.toDomain()
    }
}
