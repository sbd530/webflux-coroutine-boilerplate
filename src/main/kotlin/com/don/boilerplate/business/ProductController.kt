package com.don.boilerplate.business

import com.don.boilerplate.business.database.Product
import com.don.boilerplate.business.database.ProductRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/products")
class ProductController(
    private val productRepository: ProductRepository
) {
    @GetMapping("/{id}")
    suspend fun findOne(@PathVariable id: Long): Product? {
        return productRepository.findById(id)
    }

    @GetMapping
    fun findAll(): Flow<Product> {
        return productRepository.findAll()
    }
}