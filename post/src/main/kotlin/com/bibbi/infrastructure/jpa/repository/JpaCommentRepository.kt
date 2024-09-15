package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.CommentEntity
import org.springframework.data.jpa.repository.JpaRepository

interface JpaCommentRepository : JpaRepository<CommentEntity, String> {
}
