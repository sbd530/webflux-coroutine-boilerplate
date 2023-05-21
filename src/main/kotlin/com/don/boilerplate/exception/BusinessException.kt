package com.don.boilerplate.exception

class BusinessException(
    val errorCode: ErrorCode,
    message: String?,
    cause: Throwable?
) : RuntimeException(message, cause)
