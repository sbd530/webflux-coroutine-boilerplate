package com.don.boilerplate.configuration

import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
import org.springframework.r2dbc.connection.R2dbcTransactionManager
import org.springframework.transaction.ReactiveTransactionManager

@Configuration
@EnableR2dbcRepositories
@EnableR2dbcAuditing
class DatabaseConfiguration {
    @Bean
    fun reactiveTransactionManager(connectionFactory: ConnectionFactory) : ReactiveTransactionManager {
        return R2dbcTransactionManager(connectionFactory)
    }
}