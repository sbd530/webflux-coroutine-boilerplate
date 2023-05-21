package com.don.boilerplate.exception

import com.don.boilerplate.common.CommonResponse
import mu.KLogging
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalControllerAdvice {
    @ExceptionHandler(BusinessException::class)
    fun handleBusinessException(exception: BusinessException): ResponseEntity<CommonResponse> {
        logger.error(exception) { "" }
        return ResponseEntity
            .status(exception.errorCode.code)
            .body(CommonResponse(exception.errorCode.code, exception.errorCode.message))
    }

    companion object : KLogging()
}