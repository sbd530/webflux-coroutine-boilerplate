package com.don.boilerplate.common

data class CommonResponse(
    var code: Int = 0,
    var message: String = "",
    var details: String = ""
)