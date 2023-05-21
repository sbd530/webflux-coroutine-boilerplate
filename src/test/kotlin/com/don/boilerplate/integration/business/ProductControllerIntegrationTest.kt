package com.don.boilerplate.integration.business

import com.appmattus.kotlinfixture.kotlinFixture
import com.don.boilerplate.business.ProductController
import com.don.boilerplate.business.database.Product
import com.don.boilerplate.business.database.ProductRepository
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import kotlinx.coroutines.flow.flow
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest
import org.springframework.context.annotation.Import
import org.springframework.test.web.reactive.server.WebTestClient

@WebFluxTest
@Import(ProductController::class)
class ProductControllerIntegrationTest @Autowired constructor(
    private val client: WebTestClient
) {
    @MockkBean
    private lateinit var productRepository: ProductRepository
    val fixture = kotlinFixture()

    @Test
    fun `Retrieve all product`() {
        every {
            productRepository.findAll()
        } returns flow {
            emit(fixture<Product>())
            emit(fixture<Product>())
        }

        client
            .get()
            .uri("/products")
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .consumeWith(::println)
    }
}