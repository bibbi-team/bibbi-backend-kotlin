package com.bibbi.infrastructure.jpa.gateway

import com.bibbi.domain.gateway.FamilyGateway
import com.bibbi.domain.model.Family
import com.bibbi.infrastructure.jpa.entity.FamilyEntity
import com.bibbi.infrastructure.jpa.repository.FamilyJpaRepository
import org.springframework.stereotype.Component

@Component
class FamilyGatewayImpl(
    private val familyJpaRepository: FamilyJpaRepository
) : FamilyGateway {

    override fun save(family: Family): Family {
        return familyJpaRepository
            .save(FamilyEntity.fromDomain(family))
            .toDomain()
    }

    override fun findById(familyId: String): Family? {
        return familyJpaRepository
            .findById(familyId)
            .orElse(null)
            ?.toDomain()
    }
}
