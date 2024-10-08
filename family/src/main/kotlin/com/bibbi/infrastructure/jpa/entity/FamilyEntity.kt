package com.bibbi.infrastructure.jpa.entity

import com.bibbi.domain.model.Family
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity(name = "family")
class FamilyEntity (

    @Id
    @Column(name = "family_id", length = 26, columnDefinition = "CHAR(26)", nullable = false)
    val familyId: String,

    @Column(name = "score", nullable = false)
    val score : Int

) : BaseEntity() {

    companion object {
        fun fromDomain(family: Family) = with(family) {
            FamilyEntity(
                familyId = familyId,
                score = score
            )
        }
    }

    fun toDomain() = Family (
        familyId = familyId,
        score = score,
    )
}
