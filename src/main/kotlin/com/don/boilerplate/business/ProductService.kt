package com.don.boilerplate.business

import com.don.boilerplate.business.database.ProductRepository
import org.springframework.stereotype.Service

@Service
class ProductService(
    private val productRepository: ProductRepository
) {

}