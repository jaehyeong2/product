package jjfactory.product.domain.product

import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository: JpaRepository<Product, Long> {
    fun findAllBySellerId(sellerId: Long): List<Product>
}