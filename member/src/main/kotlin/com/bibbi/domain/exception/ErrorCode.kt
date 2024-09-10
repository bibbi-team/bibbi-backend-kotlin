package com.bibbi.domain.exception

enum class ErrorCode (
    val code : String,
    val message : String
) {

    /**
     * 기본 오류
     * @see
     */
    UNKNOWN_SERVER_ERROR("COMM0001", "알 수 없는 오류가 발생하였습니다."),
    UNAUTHORIZED("COMM0002", "인가되지 않은 접근입니다."),
    INVALID_INPUT("COMM0003", "입력값(바디 혹은 파라미터)가 유효하지 않습니다."),
    INVALID_METHOD("COMM0005", "요청 메서드가 올바르지 않습니다. API 문서를 확인하세요."),
}
