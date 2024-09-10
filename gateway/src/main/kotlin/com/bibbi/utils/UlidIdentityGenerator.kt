package com.bibbi.utils

import com.bibbi.util.IdentityGenerator
import com.github.f4b6a3.ulid.UlidCreator
import org.springframework.stereotype.Component

@Component
class UlidIdentityGenerator : IdentityGenerator {
    override fun generateIdentity(): String {
        return UlidCreator.getMonotonicUlid().toString()
    }
}
