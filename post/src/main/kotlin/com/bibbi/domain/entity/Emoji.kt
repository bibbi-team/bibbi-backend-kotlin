package com.bibbi.domain.entity

import java.util.*

enum class Emoji(
    val typeKey: String
) {
    EMOJI_1("emoji_1"),
    EMOJI_2("emoji_2"),
    EMOJI_3("emoji_3"),
    EMOJI_4("emoji_4"),
    EMOJI_5("emoji_5");

    companion object {
        fun fromString(typeKey: String): Emoji {
            return when (typeKey.uppercase(Locale.getDefault())) {
                "EMOJI_1" -> EMOJI_1
                "EMOJI_2" -> EMOJI_2
                "EMOJI_3" -> EMOJI_3
                "EMOJI_4" -> EMOJI_4
                "EMOJI_5" -> EMOJI_5
                else -> throw IllegalArgumentException()
            }
        }
    }
}
