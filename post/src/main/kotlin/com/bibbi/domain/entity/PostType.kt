package com.bibbi.domain.entity

import java.util.*

enum class PostType(
    val typeKey: String
) {
    SURVIVAL("survival"),
    MISSION("mission");

    companion object {
        fun fromString(typeKey: String): PostType {
            return when (typeKey.uppercase(Locale.getDefault())) {
                "SURVIVAL" -> PostType.SURVIVAL
                "MISSION" -> PostType.MISSION
                else -> throw IllegalArgumentException()
            }
        }
    }
}
