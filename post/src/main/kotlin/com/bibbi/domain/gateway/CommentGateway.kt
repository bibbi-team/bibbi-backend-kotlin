package com.bibbi.domain.gateway

import com.bibbi.domain.model.Comment

interface CommentGateway {
    fun save(comment: Comment): Comment
    fun delete(comment: Comment)
    fun findById(commentId: String): Comment?
}
