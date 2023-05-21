package com.don.boilerplate

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WebfluxCoroutineBoilerplateApplication

fun main(args: Array<String>) {
    runApplication<WebfluxCoroutineBoilerplateApplication>(*args)
}
