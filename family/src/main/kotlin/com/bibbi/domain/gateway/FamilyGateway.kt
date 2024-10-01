package com.bibbi.domain.gateway

import com.bibbi.domain.model.Family

interface FamilyGateway {
    fun findById(familyId: String): Family?
    fun save(family: Family): Family
}