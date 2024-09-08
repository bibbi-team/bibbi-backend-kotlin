package com.bibbi.domain.exception

open class DefaultException (

    errorCode: ErrorCode,
    data: Any? = null,

) : DomainException(errorCode, data) {

    class UnknownErrorException(data: Any?) : DefaultException(ErrorCode.UNKNOWN_SERVER_ERROR, data)
    class UnauthorizedException(data: Any?) : DefaultException(ErrorCode.UNAUTHORIZED, data)
    class InvalidInputException(data: Any?) : DefaultException(ErrorCode.INVALID_INPUT, data)
}
