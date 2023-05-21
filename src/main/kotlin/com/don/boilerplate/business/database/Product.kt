package com.don.boilerplate.business.database

import kotlinx.coroutines.flow.Flow
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.relational.core.mapping.Table
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.math.BigDecimal
import java.time.LocalDateTime

@Table("product")
data class Product(
    @Id
    val id: Long,
    val name: String,
    val price: BigDecimal,
    @CreatedDate
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @LastModifiedDate
    val updatedAt: LocalDateTime = LocalDateTime.now()
)

interface ProductRepository : CoroutineCrudRepository<Product, Long> {
    fun findByName(name: String): Flow<Product>
    fun findByNameContains(name: String): Flow<Product>
    @Query("select p from product p where p.name = :name")
    fun findCustom(name: String)
}
