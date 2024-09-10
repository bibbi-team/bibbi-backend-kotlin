package com.bibbi.infrastructure.jpa.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
open class DeletableBaseEntity (

    @Column(name = "deleted_at")
    var deletedAt: LocalDateTime? = null

) : BaseEntity()