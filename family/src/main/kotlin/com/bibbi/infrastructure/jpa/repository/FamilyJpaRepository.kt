package com.bibbi.infrastructure.jpa.repository

import com.bibbi.infrastructure.jpa.entity.FamilyEntity
import org.springframework.data.jpa.repository.JpaRepository

interface FamilyJpaRepository : JpaRepository<FamilyEntity, String> {
}
