package com.don.boilerplate.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(
    val status: HttpStatus = HttpStatus.OK,
    val code: Int = 0,
    val message: String = ""
) {
    NOT_FOUND(status = HttpStatus.NOT_FOUND, message = "Not found"),
    BAD_REQUEST(status = HttpStatus.BAD_REQUEST, message = "Bad request"),
}