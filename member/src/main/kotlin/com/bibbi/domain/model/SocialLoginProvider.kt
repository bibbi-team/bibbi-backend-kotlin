package com.bibbi.domain.model

import com.bibbi.domain.exception.DefaultException

enum class SocialLoginProvider {

    APPLE, // 애플 로그인
    GOOGLE, // 구글 로그인
    KAKAO, // 카카오 로그인
    INTERNAL; // 내부 로그인

    companion object {
        fun fromString(provider: String): SocialLoginProvider {
            return when (provider) {
                "APPLE" -> APPLE
                "GOOGLE" -> GOOGLE
                "KAKAO" -> KAKAO
                "INTERNAL" -> INTERNAL
                else -> throw DefaultException.InvalidInputException(provider)
            }
        }
    }
}
